package mw.forwardplay.mdima.modules;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

import mw.forwardplay.mdima.R;
import mw.forwardplay.mdima.adapters.ListData;
import mw.forwardplay.mdima.entities.Regions;

public class RegionsFragment extends SuperFragment {
    private DatabaseReference regionReference;
    public void RegionsFragment()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        regionReference = firebaseDatabase.getReference("regions");
        showRegions();
    }

    @Override
    protected void setInformationBar()
    {
        listActivity.setInformationBar(
            "Regions in Malawi", "Select a region:",
            R.drawable.map
        );
    }

    private void showRegions() {
        setRecyclerListData(regionReference, new ListEntityData() {
            @Override
            public ListData onSetListData(DataSnapshot snapshot, ListData listData) {
                 StringBuilder description = new StringBuilder();
                 Regions region = snapshot.getValue(Regions.class);
                 listData.setId(region.getRegion());
                 listData.setTitle(region.getRegion());
                 listData.params.put("location_num",
                         String.valueOf(region.getLocations().size()));
                 listData.params.put("status",
                         region.getGroups()!=null && region.getGroups().size() >= 1 ?
                                 "Some locations have a schedule" : "No loadshedding schedules"
                         );
                 listData.setDescription(
                         description
                             .append("Region has")
                             .append(" ").append(region.getLocations().size())
                             .append(" ").append("registered locations").toString()
                 );
                 return listData;
            }

            @Override
            public void onClick(int index, List<ListData> listData) {
                ListData data = listData.get(index);
                String region = data.getId();
                LocationsFragment locationsFragment = new LocationsFragment();
                locationsFragment.setRegion(region);
                locationsFragment.setTitle(region);
                locationsFragment.setSubtitle(
                      new StringBuilder()
                      .append( data.params.get("location_num")  + " Location(s) found")
                      .append("\n")
                      .append(data.params.get("status"))
                      .toString()
                    );
                replaceFragment(locationsFragment, region);
            }
        });
    }

    @Override
    public void onResume()
    {
        super.onResume();
        showRegions();
        setInformationBar();
    }
}
