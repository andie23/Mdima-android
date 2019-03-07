package mw.forwardplay.mdima;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import mw.forwardplay.mdima.cache.AreaDao;
import mw.forwardplay.mdima.cache.AreaEntity;
import mw.forwardplay.mdima.cache.GroupDao;
import mw.forwardplay.mdima.cache.GroupEntity;
import mw.forwardplay.mdima.cache.MdimaDatabase;
import mw.forwardplay.mdima.cache.ScheduleDao;
import mw.forwardplay.mdima.cache.ScheduleEntity;

public class AreaViewActivity extends AppCompatActivity {
    public final static String AREA_VIEW_BY_ID = "area_view_by_id";
    private int areaId;
    private String groupName;
    private TextView locationName;
    private TextView blackoutDate;
    private TextView startingTime;
    private TextView finishingTime;
    private TextView numberOfBlackouts;
    private TextView averageDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_view);
        locationName = (TextView) findViewById(R.id.locationName);
        blackoutDate = (TextView) findViewById(R.id.blackoutDate);
        startingTime = (TextView) findViewById(R.id.startingTime);
        finishingTime = (TextView) findViewById(R.id.finishingTime);
        numberOfBlackouts = (TextView) findViewById(R.id.numberOfBlackouts);
        averageDuration = (TextView) findViewById(R.id.averageDuration);

        Intent areaViewIntent = getIntent();
        areaId = areaViewIntent.getIntExtra(AREA_VIEW_BY_ID, 0);
        setLocationInformation();
    }

    public void onShowAllSchedules(View view)
    {
        Intent schedulesIntent = new Intent(AreaViewActivity.this,
                ScheduleListActivity.class);
        schedulesIntent.putExtra(ScheduleListActivity.SCHEDULES_BY_GROUP_ID, groupName);
        startActivity(schedulesIntent);
    }

    void setLocationInformation()
    {
        MdimaDatabase db = MdimaDatabase.getInstance(this);
        AreaDao areaDao = db.areaDao();
        GroupDao groupDao = db.groupDao();
        ScheduleDao scheduleDao = db.scheduleDao();

        AreaEntity areaEntity = areaDao.fetchByAreaId(areaId);

        if(areaEntity!=null)
        {
            locationName.setText(areaEntity.getName());
            GroupEntity groupEntity = groupDao.fetchByAreaId(areaEntity.getId());
           if(groupEntity!=null)
            {
                groupName = groupEntity.getName();
                List<ScheduleEntity> scheduleEntities = scheduleDao.fetchAllByGroupId(groupEntity.getName());
                if(scheduleEntities.size() >=1)
                {
                    ScheduleEntity scheduleEntity = scheduleEntities.get(0);
                    int avgDuration = scheduleDao.averageGroupDuration(groupEntity.getName());
                    int blackoutCount = scheduleDao.countGroupBlackouts(groupEntity.getName());
                    blackoutDate.setText(String.valueOf(scheduleEntity.getDate()));
                    startingTime.setText(String.valueOf(scheduleEntity.getStartingTime()));
                    finishingTime.setText(String.valueOf(scheduleEntity.getFinishTime()));
                    numberOfBlackouts.setText(String.valueOf(blackoutCount));
                    averageDuration.setText(String.valueOf(avgDuration));
                }

            }

        }
    }
}
