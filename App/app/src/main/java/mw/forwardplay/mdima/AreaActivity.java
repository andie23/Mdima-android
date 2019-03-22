package mw.forwardplay.mdima;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mw.forwardplay.mdima.adapters.DefaultListAdapter;
import mw.forwardplay.mdima.adapters.ListData;
import mw.forwardplay.mdima.entities.Areas;
import mw.forwardplay.mdima.entities.Locations;

public class AreaActivity extends SuperActivity {
    public final static String AREAS_BY_LOCATION="areas_by_location";
    private RecyclerView recyclerView;
    private String location;
    private HashMap<String, Locations> locationsHashMap;
    private HashMap<String, Areas> areasHashMap;
    private DatabaseReference locationDbRef;
    private DatabaseReference areaDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_area);
        Intent areaIntent = getIntent();
        location = areaIntent.getStringExtra(AREAS_BY_LOCATION);
        locationDbRef = firebaseDatabase.getReference("/locations");
        areaDbRef = firebaseDatabase.getReference("/areas");
        super.onCreate(savedInstanceState);
    }

    private void setLocationsHashMap()
    {
        locationDbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                locationsHashMap = (HashMap<String, Locations>) dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(AreaActivity.this, "Unabled to fetch locations",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setAreasHashMap()
    {
        areaDbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                areasHashMap = (HashMap<String, Areas>) dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(AreaActivity.this, "Unable to retrieve areas",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<ListData> castToListData()
    {
        List<ListData> listDataEntities = new ArrayList<>();
        List<String> locations = locationsHashMap.get(location).getAreas();

        for(String areaName: locations)
        {
            ListData listData = new ListData();
            listData.setId(areaName);
            listData.setTitle(areaName);
            listData.setDescription("View load-shedding schedule for " + areaName);
            listDataEntities.add(listData);
        }
        return listDataEntities;
    }

    private void showAreasByLocationId()
    {
        final List<ListData> listDataList = castToListData();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        DefaultListAdapter adapter = new DefaultListAdapter(listDataList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setEventListerner(new DefaultListAdapter.ListEventListerner() {
            @Override
            public void onClick(int position) {
                Intent areaViewIntent =  new Intent(AreaActivity.this,
                        AreaViewActivity.class);
                String area = listDataList.get(position).getId();
                areaViewIntent.putExtra(AreaViewActivity.AREA_VIEW_BY_ID, area);
                startActivity(areaViewIntent);
            }
        });
    }
}
