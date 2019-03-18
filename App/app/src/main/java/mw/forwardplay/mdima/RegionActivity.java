package mw.forwardplay.mdima;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import mw.forwardplay.mdima.adapters.DefaultListAdapter;
import mw.forwardplay.mdima.adapters.ListData;
import mw.forwardplay.mdima.cache.MdimaDatabase;
import mw.forwardplay.mdima.cache.RegionEntity;
import mw.forwardplay.mdima.commons.CommonToolbar;

public class RegionActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region);
        actionBar = CommonToolbar.getActionbar(this);
        actionBar.setTitle("Select Region:");
        recyclerView = (RecyclerView) findViewById(R.id.regionRecyler);
        initiateRecyclerView();
    }

    private List<RegionEntity> getRegionEntities() {
        MdimaDatabase database = MdimaDatabase.getInstance(this);
        List<RegionEntity> regionEntities = database.regionDao().fetchAll();
        return regionEntities!=null ? regionEntities : null;
    }

    List<ListData> castToListData(List<RegionEntity> regionEntities)
    {
        List<ListData> listDataList = new ArrayList<>();
        for(RegionEntity regionEntity: regionEntities)
        {
            ListData listDataItem =  new ListData();
            listDataItem.setTitle(regionEntity.getName());
            listDataItem.setDescription("View locations in "+ regionEntity.getName());
            listDataItem.setId(regionEntity.getId());
            listDataList.add(listDataItem);
        }
        return listDataList;
    }

    void initiateRecyclerView()
    {
        List<RegionEntity> regionEntities = getRegionEntities();
        if(regionEntities.isEmpty())
            return;
        final List<ListData> listData = castToListData(regionEntities);
        DefaultListAdapter adapter = new DefaultListAdapter(listData);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layout);
        recyclerView.setAdapter(adapter);
        adapter.setEventListerner(new DefaultListAdapter.ListEventListerner() {
            @Override
            public void onClick(int position) {
                Intent locationIntent = new Intent(RegionActivity.this,
                        LocationActivity.class);
                ListData regionListData = listData.get(position);
                int regionId = regionListData.getId();
                locationIntent.putExtra(LocationActivity.LOCATIONS_BY_REGION, regionId);
                startActivity(locationIntent);
            }
        });


    }
}
