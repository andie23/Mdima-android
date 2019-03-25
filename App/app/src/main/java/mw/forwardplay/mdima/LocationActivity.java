package mw.forwardplay.mdima;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import mw.forwardplay.mdima.adapters.ListData;
import mw.forwardplay.mdima.entities.Locations;
import mw.forwardplay.mdima.helpers.RecyclerHelper;

public class LocationActivity extends SuperActivity {
    public final static String LOCATIONS_BY_REGION="locations_by_region";
    private String region;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_location);
        Intent locationsIntent = getIntent();
        region  = locationsIntent.getStringExtra(LOCATIONS_BY_REGION);
        progressBar = (ProgressBar) findViewById(R.id.spinner);
        progressBar.setVisibility(View.VISIBLE);
        showLocations();
        super.onCreate(savedInstanceState);
    }

    private void showLocations()
    {
        Query locationQuery = fbLocationsRef.child(region);

        locationQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final List<ListData> locationListData = new ArrayList<>();
                for(DataSnapshot snapshot: dataSnapshot.getChildren())
                {
                    StringBuilder description = new StringBuilder();
                    ListData locationData = new ListData();
                    Locations location = snapshot.getValue(Locations.class);
                    description.append(location.getRegion())
                                .append("\n")
                                .append(location.getAreas()!=null ? location.getAreas().size() : "0")
                                .append(" Areas found")
                                .append("\n")
                                .append(location.getGroups()!=null &&
                                       location.getGroups().size()>=1 ?
                                       "Loadshedding schedule(s) found"
                                       : "No load-shedding schedules");

                    locationData.setId(location.getLocation());
                    locationData.setTitle(location.getLocation());
                    locationData.setDescription(description.toString());
                    locationListData.add(locationData);
                }

                if(!locationListData.isEmpty())
                {
                    setViewItemList(locationListData, new RecyclerHelper.OnClickItemList() {
                        @Override
                        public void onClick(int position) {
                            Intent areaIntent = new Intent(LocationActivity.this,
                                    AreaActivity.class);
                            areaIntent.putExtra(AreaActivity.AREAS_BY_LOCATION,
                                    locationListData.get(position).getId());
                            startActivity(areaIntent);
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(LocationActivity.this,
                        "Unable to retrieve locations", Toast.LENGTH_SHORT).show();
            }
        });
        progressBar.setVisibility(View.GONE);
    }

}
