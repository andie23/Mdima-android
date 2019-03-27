package mw.forwardplay.mdima.modules;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.List;

import mw.forwardplay.mdima.DataListActivity;
import mw.forwardplay.mdima.R;
import mw.forwardplay.mdima.adapters.DefaultListAdapter;
import mw.forwardplay.mdima.adapters.ListData;
import mw.forwardplay.mdima.entities.Locations;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocationsFragment extends SuperFragment {
    private String region;
    private String title;
    private String subtitle;

    protected DatabaseReference locationsReference;

    public LocationsFragment() {
        // Required empty public constructor
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setSubtitle(String subtitle)
    {
        this.subtitle = subtitle;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    @Override
    public void setInformationBarText()
    {
        listActivity.setTitle(title);
        listActivity.setSubtitle(subtitle);
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        locationsReference = firebaseDatabase.getReference("locations");
        showLocations();
    }

    private void showLocations() {
        if(region==null) {return;}
        Query locationQ = locationsReference.child(region);
        setRecyclerListData((DatabaseReference) locationQ, new ListEntityData() {
            @Override
            public ListData onSetListData(DataSnapshot snapshot, ListData listData) {
                StringBuilder description = new StringBuilder();
                Locations location = snapshot.getValue(Locations.class);
                if(location.getAreas()==null || location.getAreas().isEmpty())
                {
                    listData.params.put(DefaultListAdapter.SET_SELECT_ICON,
                            DefaultListAdapter.SELECT_ICON_INVISIBLE);
                }else{
                    listData.params.put(DefaultListAdapter.SET_SELECT_ICON,
                            DefaultListAdapter.SELECT_ICON_VISIBLE);
                }
                listData.params.put("area_num",
                   location.getAreas()!= null ? String.valueOf(location.getAreas().size()) : "0"
                );
                listData.params.put("status",
                        location.getGroups()!=null && location.getGroups().size()>=1 ?
                                "Some areas have a schedule" : "No schedules"
                        );
                listData.setId(location.getLocation());
                listData.setTitle(location.getLocation());
                listData.setDescription(
                        description.append("Location has")
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
            public void onClick(int index, List<ListData> listData) {
                ListData data = listData.get(index);
                if(data.getId()!=null) {
                    String location = data.getId();
                    AreasFragment areasFragment = new AreasFragment();
                    areasFragment.setLocation(location);
                    areasFragment.setTitle(location);
                    areasFragment.setSubtitle(
                            new StringBuilder()
                                    .append(region).append(" | ")
                                    .append(data.params.get("area_num")).append(" area(s) found")
                                    .append("\n")
                                    .append(data.params.get("status"))
                                    .toString()
                    );
                    replaceFragment(areasFragment, location);
                }
            }
        });
    }

    @Override
    public void onResume()
    {
        super.onResume();
        showLocations();
        setInformationBarText();
    }


}
