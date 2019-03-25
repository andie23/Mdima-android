package mw.forwardplay.mdima.modules;


import android.arch.persistence.room.Database;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import mw.forwardplay.mdima.R;
import mw.forwardplay.mdima.adapters.ListData;
import mw.forwardplay.mdima.entities.Areas;

/**
 * A simple {@link Fragment} subclass.
 */
public class AreasFragment extends SuperFragment {
    private String location;
    protected DatabaseReference locationReference;

    public AreasFragment() {
        // Required empty public constructor
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        locationReference = firebaseDatabase.getReference("areas");
        setLocation("Kwacha");
        showAreas();
    }

    private void showAreas() {
        if (location == null) { return; }

        Query areasQ = locationReference.child(location);
        setListData((DatabaseReference) areasQ, new ListEntityData() {
            @Override
            public ListData onSetListData(DataSnapshot snapshot, ListData listData) {
                Areas area = snapshot.getValue(Areas.class);
                listData.setId(area.getArea());
                listData.setTitle(area.getArea());
                listData.setDescription(
                    new StringBuilder()
                        .append(area.getLocation())
                        .append("\n")
                        .append(area.getRegion())
                        .append("\n")
                        .append(
                            area.getGroups()!= null ? "Area has load-shedding schedule(s)" :
                                    "no load-shedding schedules found"
                        )
                        .toString()
                );
                return listData;
            }

            @Override
            public void onClick(int index) {

            }
        });
    }
}
