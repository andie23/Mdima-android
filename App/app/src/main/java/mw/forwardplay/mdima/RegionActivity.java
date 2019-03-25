package mw.forwardplay.mdima;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import mw.forwardplay.mdima.adapters.ListData;
import mw.forwardplay.mdima.entities.Regions;
import mw.forwardplay.mdima.helpers.RecyclerHelper;

public class RegionActivity extends AppCompatActivity {
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_region);
        progressBar = (ProgressBar) findViewById(R.id.spinner);
        progressBar.setVisibility(View.VISIBLE);
        super.onCreate(savedInstanceState);
        //showRegions();
    }
    /*
    private void showRegions()
    {
        fbRegionsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final List<ListData> regionsListData = new ArrayList<>();
                for(DataSnapshot snapshot: dataSnapshot.getChildren())
                {

                    Regions region = snapshot.getValue(Regions.class);
                    StringBuilder regionDescription = new StringBuilder();
                    regionDescription.append(String.valueOf(region.getLocations().size()))
                            .append(" location(s) found");
                    ListData regionData = new ListData();
                    regionData.setTitle(region.getRegion());
                    regionData.setDescription(regionDescription.toString());
                    regionData.setId(region.getRegion());
                    regionsListData.add(regionData);
                }

                if (regionsListData.size() >= 1)
                {
                    setViewItemList(regionsListData, new RecyclerHelper.OnClickItemList() {
                        @Override
                        public void onClick(int position) {
                            Intent locationsIntent = new Intent(RegionActivity.this,
                                    LocationActivity.class);
                            String regionName = regionsListData.get(position).getId();
                            locationsIntent.putExtra(LocationActivity.LOCATIONS_BY_REGION, regionName);
                            startActivity(locationsIntent);
                        }
                    });
                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(RegionActivity.this, "Couldn't retrieve regions",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }*/
}
