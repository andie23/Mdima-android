package mw.forwardplay.mdima.modules;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.List;

import mw.forwardplay.mdima.adapters.ListData;
import mw.forwardplay.mdima.entities.Schedules;

/**
 * A simple {@link Fragment} subclass.
 */
public class SchedulesFragment extends SuperFragment {
    private DatabaseReference schedulesReference;
    private String group;

    public void SchedulesFragment() {
        // Required empty public constructor
    }

    public void setGroup(String group)
    {
        this.group = group;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        schedulesReference = firebaseDatabase.getReference("schedules");
        showSchedules();
    }

    void showSchedules(){
        Query groupQ =  schedulesReference.child(group);
        setRecyclerListData((DatabaseReference)groupQ, new ListEntityData() {
            @Override
            public ListData onSetListData(DataSnapshot snapshot, ListData listData) {
                Schedules schedule = snapshot.getValue(Schedules.class);
                listData.setId(schedule.getName());
                listData.setTitle(schedule.getName());
                listData.setDescription(
                    new StringBuilder()
                            .append("Duration: ")
                            .append(schedule.getDuration())
                            .append(" hour(s)")
                            .append("\n")
                            .append("Starting: ")
                            .append(schedule.getStartingDate())
                            .append("\n")
                            .append("Ending: ")
                            .append(schedule.getEndingDate())
                            .toString()
                );
                return listData;
            }

            @Override
            public void onClick(int index, List<ListData> listData) {

            }
        });
    }
}
