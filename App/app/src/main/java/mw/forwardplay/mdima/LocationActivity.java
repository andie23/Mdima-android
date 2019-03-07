package mw.forwardplay.mdima;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import mw.forwardplay.mdima.adapters.DefaultListAdapter;
import mw.forwardplay.mdima.adapters.ListData;
import mw.forwardplay.mdima.cache.AreaEntity;
import mw.forwardplay.mdima.cache.LocationEntity;
import mw.forwardplay.mdima.cache.MdimaDatabase;

public class LocationActivity extends AppCompatActivity {
    public final static String LOCATIONS_BY_REGION="locations_by_region";
    private RecyclerView recyclerView;
    private int regionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        recyclerView = (RecyclerView) findViewById(R.id.locationRecycler);

        Intent locationsIntent = getIntent();
        regionId = locationsIntent.getIntExtra(LOCATIONS_BY_REGION,0);

        showLocationListByRegion();
    }

    private List<LocationEntity> getLocationEntities()
    {
        MdimaDatabase db = MdimaDatabase.getInstance(this);
        List<LocationEntity> locationEntities = db.locationDao().fetchByRegionId(regionId);
        return locationEntities!=null ? locationEntities : null;
    }

    private List<ListData> castToListData(List<LocationEntity> locationEntities)
    {
        List<ListData> listDataEntities = new ArrayList<>();

        for(LocationEntity locationEntity: locationEntities)
        {
            ListData listData = new ListData();
            listData.setId(locationEntity.getId());
            listData.setTitle(locationEntity.getName());
            listData.setDescription("View areas in "+ locationEntity.getName());
            listDataEntities.add(listData);
        }
        return listDataEntities;
    }

    private void showLocationListByRegion()
    {
        List<LocationEntity> locationEntities = getLocationEntities();
        if(locationEntities.isEmpty())
            return;
        final List<ListData> locationListData = castToListData(locationEntities);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        DefaultListAdapter adapter = new DefaultListAdapter(locationListData);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        adapter.setEventListerner(new DefaultListAdapter.ListEventListerner() {
            @Override
            public void onClick(int position) {
                Intent areaIntent = new Intent(LocationActivity.this,
                        AreaActivity.class);
                int locationId = locationListData.get(position).getId();
                areaIntent.putExtra(AreaActivity.AREAS_BY_LOCATION, locationId);
                startActivity(areaIntent);
            }
        });
    }
}
