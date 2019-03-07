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
import mw.forwardplay.mdima.cache.MdimaDatabase;

public class AreaActivity extends AppCompatActivity {
    public final static String AREAS_BY_LOCATION="areas_by_location";
    private RecyclerView recyclerView;
    private int locationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        recyclerView = (RecyclerView) findViewById(R.id.areaRecycler);
        Intent areaIntent = getIntent();
        locationId = areaIntent.getIntExtra(AREAS_BY_LOCATION, 0);
        showAreasByLocationId();
    }

    private List<AreaEntity> getAreaEntities()
    {
        MdimaDatabase db = MdimaDatabase.getInstance(this);
        List<AreaEntity> areaEntities = db.areaDao().fetchAllByLocationId(locationId);
        return areaEntities;
    }

    private List<ListData> castToListData(List<AreaEntity> areaEntities)
    {
        List<ListData> listDataEntities = new ArrayList<>();

        for(AreaEntity areaEntity: areaEntities)
        {
            ListData listData = new ListData();
            listData.setId(areaEntity.getId());
            listData.setTitle(areaEntity.getName());
            listData.setDescription("View loadshedding plan for "+ areaEntity.getName());
            listDataEntities.add(listData);
        }

        return listDataEntities;
    }

    private void showAreasByLocationId()
    {
        List<AreaEntity> areaEntities = getAreaEntities();
        if(areaEntities.isEmpty())
            return;

        final List<ListData> listDataList = castToListData(areaEntities);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        DefaultListAdapter adapter = new DefaultListAdapter(listDataList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setEventListerner(new DefaultListAdapter.ListEventListerner() {
            @Override
            public void onClick(int position) {
                Intent areaViewIntent =  new Intent(AreaActivity.this,
                        AreaViewActivity.class);
                int areaId = listDataList.get(position).getId();
                areaViewIntent.putExtra(AreaViewActivity.AREA_VIEW_BY_ID, areaId);
                startActivity(areaViewIntent);
            }
        });
    }
}
