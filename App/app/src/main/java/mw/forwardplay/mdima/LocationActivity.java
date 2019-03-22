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
import mw.forwardplay.mdima.entities.Locations;
import mw.forwardplay.mdima.entities.Regions;

public class LocationActivity extends SuperActivity {
    public final static String LOCATIONS_BY_REGION="locations_by_region";
    private RecyclerView recyclerView;
    private String region;
    private HashMap<String, Regions> regionsHashMap;
    private HashMap<String, Locations> locationsHashMap;
    private DatabaseReference regionDbRef;
    private DatabaseReference locationDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_location);
        Intent locationsIntent = getIntent();
        region = locationsIntent.getStringExtra(LOCATIONS_BY_REGION);
        regionDbRef = firebaseDatabase.getReference("/regions");
        locationDbRef = firebaseDatabase.getReference("/locations");
        super.onCreate(savedInstanceState);
    }

    private void setRegionsHashMap()
    {
        regionDbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                regionsHashMap = (HashMap<String, Regions>) dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(LocationActivity.this, "Failed to retrieve region data",
                        Toast.LENGTH_SHORT).show();
            }
        });
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
                Toast.makeText(LocationActivity.this, "Failed to retrieve locations",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<ListData> castToListData()
    {
        List<ListData> listDataEntities = new ArrayList<>();
        List<String> locations = regionsHashMap.get(region).getLocations();

        for(String locationName: locations)
        {
            ListData listData = new ListData();
            listData.setId(locationName);
            listData.setTitle(locationName);
            listData.setDescription(region);
            listDataEntities.add(listData);
        }
        return listDataEntities;
    }

    private void showLocationListByRegion()
    {
        final List<ListData> locationListData = castToListData();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        DefaultListAdapter adapter = new DefaultListAdapter(locationListData);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        adapter.setEventListerner(new DefaultListAdapter.ListEventListerner() {
            @Override
            public void onClick(int position) {
                Intent areaIntent = new Intent(LocationActivity.this,
                        AreaActivity.class);
                String location = locationListData.get(position).getId();
                areaIntent.putExtra(AreaActivity.AREAS_BY_LOCATION, location);
                startActivity(areaIntent);
            }
        });
    }
}
