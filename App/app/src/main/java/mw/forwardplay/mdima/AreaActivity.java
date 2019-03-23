package mw.forwardplay.mdima;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import mw.forwardplay.mdima.adapters.ListData;
import mw.forwardplay.mdima.entities.Areas;

public class AreaActivity extends SuperActivity {
    public final static String AREAS_BY_LOCATION="areas_by_location";
    private String location;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_area);
        Intent areaIntent = getIntent();
        location = areaIntent.getStringExtra(AREAS_BY_LOCATION);
        progressBar = (ProgressBar) findViewById(R.id.spinner);
        progressBar.setVisibility(View.VISIBLE);
        showAreas();
        super.onCreate(savedInstanceState);
    }

    void showAreas()
    {
        Query areaQuery = fbAreasRef.child(location);

        areaQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final List<ListData> areaListData = new ArrayList<>();
                for(DataSnapshot snapshot: dataSnapshot.getChildren())
                {
                    StringBuilder description = new StringBuilder();
                    ListData areaData = new ListData();
                    Areas area = snapshot.getValue(Areas.class);

                    areaData.setId(area.getArea());
                    areaData.setTitle(area.getArea());
                    areaData.setDescription(
                        description.append(area.getRegion())
                            .append("\n")
                            .append(area.getLocation())
                            .append("\n")
                            .append(area.getGroups()!=null && area.getGroups().size()>=1
                                ? "This area has a load-shedding schedule"
                                : "No loadshedding schedule found")
                            .toString()
                    );
                    areaListData.add(areaData);
                }

                if(!areaListData.isEmpty())
                {
                    setViewItemList(areaListData, new OnClickItemList() {
                        @Override
                        public void onClick(int position) {
                            Intent areaViewIntent = new Intent(AreaActivity.this,
                                    AreaViewActivity.class);

                            areaViewIntent.putExtra(AreaActivity.AREAS_BY_LOCATION,
                                    areaListData.get(position).getId());
                            startActivity(areaViewIntent);
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(AreaActivity.this, "Unable to retrieve areas",
                        Toast.LENGTH_SHORT).show();
            }
        });
        progressBar.setVisibility(View.GONE);
    }
}
