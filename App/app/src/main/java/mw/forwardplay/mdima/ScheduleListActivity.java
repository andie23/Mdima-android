package mw.forwardplay.mdima;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;


public class ScheduleListActivity extends SuperActivity {
    public final static String SCHEDULES_BY_GROUP_ID = "schedules_by_group_name";
    private RecyclerView recyclerView;
    private String groupName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_schedule_list);
        super.onCreate(savedInstanceState);
    }

}
