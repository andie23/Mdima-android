package mw.forwardplay.mdima.modules;


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
import mw.forwardplay.mdima.entities.Locations;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocationsFragment extends SuperFragment {
    private String region;
    protected DatabaseReference locationsReference;

    public LocationsFragment() {
        // Required empty public constructor
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        locationsReference = firebaseDatabase.getReference("locations");
        setRegion("Southern Region");
        showLocations();
    }

    private void showLocations() {
        if(region==null) {return;}
        Query locationQ = locationsReference.child(region);
        setListData((DatabaseReference) locationQ, new ListEntityData() {
            @Override
            public ListData onSetListData(DataSnapshot snapshot, ListData listData) {
                StringBuilder description = new StringBuilder();
                Locations location = snapshot.getValue(Locations.class);
                listData.setId(location.getLocation());
                listData.setTitle(location.getLocation());
                listData.setDescription(
                        description.append(location.getRegion())
                                .append("\n")
                                .append("Location has")
                                .append(" ")
                                .append(location.getAreas()!=null ?
                                        location.getAreas().size() : 0)
                                .append(" ")
                                .append("area(s)")
                                .append("\n")
                                .append(location.getGroups()!=null &&
                                        !location.getGroups().isEmpty() ? "Load-shedding schedule" +
                                        " found in some areas" : "No load-shedding schedule")
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
