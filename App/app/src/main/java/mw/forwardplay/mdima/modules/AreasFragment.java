package mw.forwardplay.mdima.modules;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.List;

import mw.forwardplay.mdima.AreaViewActivity;
import mw.forwardplay.mdima.R;
import mw.forwardplay.mdima.adapters.ListData;
import mw.forwardplay.mdima.entities.Areas;

/**
 * A simple {@link Fragment} subclass.
 */
public class AreasFragment extends SuperFragment {
    private String location;
    private String title;
    private String subtitle;

    protected DatabaseReference locationReference;

    public AreasFragment() {
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

    public void setLocation(String location)
    {
        this.location = location;
    }

    @Override
    public  void setInformationBar()
    {
        listActivity.setInformationBar(
                title, subtitle, R.drawable.map
        );
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        locationReference = firebaseDatabase.getReference("areas");
        showAreas();
    }

    private void showAreas() {
        if (location == null) { return; }

        Query areasQ = locationReference.child(location);
        setRecyclerListData((DatabaseReference) areasQ, new ListEntityData() {
            @Override
            public ListData onSetListData(DataSnapshot snapshot, ListData listData) {
                Areas area = snapshot.getValue(Areas.class);
                List<String> groups = area.getGroups();
                listData.params.put("region", area.getRegion());
                listData.params.put("location", area.getLocation());
                listData.setId(area.getArea());
                listData.setTitle(area.getArea());
                listData.setDescription(
                    area.getGroups()!= null ? "Area has load-shedding schedule(s)" :
                    "no load-shedding schedules found"
                );
                return listData;
            }

            @Override
            public void onClick(int index, List<ListData> listData) {
                ListData data = listData.get(index);
                String area = data.getId();
                Intent areaViewIntent = new Intent(listActivity, AreaViewActivity.class);
                areaViewIntent.putExtra(AreaViewActivity.AREA_NAME, area);
                areaViewIntent.putExtra(AreaViewActivity.AREA_LOCATION, data.params.get("location"));
                startActivity(areaViewIntent);
            }
        });
    }

    @Override
    public void onResume()
    {
        super.onResume();
        showAreas();
        setInformationBar();
    }
}
