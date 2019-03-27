package mw.forwardplay.mdima.modules;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

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

    private void showRegions() {
        setRecyclerListData(regionReference, new ListEntityData() {
            @Override
            public ListData onSetListData(DataSnapshot snapshot, ListData listData) {
                 StringBuilder description = new StringBuilder();
                 Regions region = snapshot.getValue(Regions.class);
                 listData.setId(region.getRegion());
                 listData.setTitle(region.getRegion());
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
                String region = listData.get(index).getId();
                LocationsFragment locationsFragment = new LocationsFragment();
                locationsFragment.setRegion(region);
                replaceFragment(locationsFragment);
            }
        });
    }
}
