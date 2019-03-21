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
import mw.forwardplay.mdima.cache.LocationEntity;
import mw.forwardplay.mdima.cache.MdimaDatabase;
import mw.forwardplay.mdima.cache.ScheduleEntity;

public class ScheduleListActivity extends SuperActivity {
    public final static String SCHEDULES_BY_GROUP_ID = "schedules_by_group_name";
    private RecyclerView recyclerView;
    private String groupName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_schedule_list);
        recyclerView = (RecyclerView) findViewById(R.id.scheduleRecycler);
        //actionBar.setTitle("Blackout Schedule:");
        Intent scheduleIntent = getIntent();
        groupName = scheduleIntent.getStringExtra(SCHEDULES_BY_GROUP_ID);
        showSchedule();
        super.onCreate(savedInstanceState);
    }

    private List<ScheduleEntity> getSchedules()
    {
        MdimaDatabase db = MdimaDatabase.getInstance(this);
        List<ScheduleEntity> scheduleEntities = db.scheduleDao().fetchAllByGroupId(groupName);
        return scheduleEntities;
    }

    private List<ListData> castToListData(List<ScheduleEntity> scheduleEntities)
    {
        List<ListData> listDataEntities = new ArrayList<>();
        int count = 1;
        for(ScheduleEntity scheduleEntity: scheduleEntities)
        {
            ListData listData = new ListData();
            listData.setId(scheduleEntity.getId());
            listData.setTitle("Blackout #"+ String.valueOf(count));
            listData.setDescription(
                    String.valueOf(scheduleEntity.getDate())+ "\n" +
                    "Starting at " +
                    String.valueOf(scheduleEntity.getStartingTime()) + " and finish at " +
                    String.valueOf(scheduleEntity.getFinishTime()) + "\n" +
                    String.valueOf(scheduleEntity.getDuration()) + " hours duration"
            );
            listDataEntities.add(listData);
            ++count;
        }
        return listDataEntities;
    }

    private void showSchedule()
    {
        List<ScheduleEntity> scheduleEntities = getSchedules();
        if(scheduleEntities.isEmpty())
            return;
        final List<ListData> scheduleListData = castToListData(scheduleEntities);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        DefaultListAdapter adapter = new DefaultListAdapter(scheduleListData);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
