package mw.forwardplay.mdima;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mw.forwardplay.mdima.adapters.ListData;
import mw.forwardplay.mdima.adapters.StaticMenuListAdapter;
import mw.forwardplay.mdima.helpers.RecyclerHelper;

public class MainActivity extends SuperActivity {
    private static List<ListData> menuOptionListData;
    private static RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.staticMenuListRecycler);
        menuOptionListData = new ArrayList<>();
        setupOptions();
        setRecyclerView();
    }

    private void setupOptions()
    {
        setPrimaryLocationOption();
        setTrackLocationsOption();
        setBrowseLocationOption();
        setGpsLocationOption();

    }

    private void setRecyclerView()
    {
        RecyclerHelper recyclerHelper = new RecyclerHelper(recyclerView);
        recyclerHelper.setStaticMenuRecycler(this, menuOptionListData,
            new RecyclerHelper.OnClickItemList() {
                @Override
                public void onClick(int index) {
                    ListData data = menuOptionListData.get(index);

                    switch(data.getId())
                    {
                        case "browse_locations":
                            Intent dataListIntent = new Intent(MainActivity.this,
                                    DataListActivity.class);
                            startActivity(dataListIntent);
                            break;
                        case "primary_location":
                            Toast.makeText(MainActivity.this, "Primary location is not set!!",
                                    Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            break;
                    }
                }
            });
    }

    private void setMenuOption(String itemId, String title, String subtitle, int resourceId)
    {
        ListData data = new ListData();
        data.setId(itemId);
        data.setTitle(title);
        data.setDescription(subtitle);
        data.params.put(StaticMenuListAdapter.ICON, String.valueOf(resourceId));
        menuOptionListData.add(data);
    }

    final void setPrimaryLocationOption(){
        setMenuOption(
           "primary_location","Home", "View schedules of your primary location",
           R.drawable.home
        );
    }

    final void setBrowseLocationOption() {
        setMenuOption(
          "browse_locations", "Browse Locations", "View regions, locations" +
                        " and areas of interest", R.drawable.map
        );
    }

    final void setTrackLocationsOption()
    {
        setMenuOption(
                "tracked_locations" ,"Tracked Locations", "View locations" +
                        " on your track-list", R.drawable.pin
        );
    }

    final void setGpsLocationOption() {
        setMenuOption(
           "gps_locations", "Detect Location", "Use GPS on your device " +
                "to detect location", R.drawable.gps
        );
    }
}
