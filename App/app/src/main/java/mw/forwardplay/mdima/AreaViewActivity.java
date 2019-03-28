package mw.forwardplay.mdima;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import mw.forwardplay.mdima.entities.Areas;
import mw.forwardplay.mdima.helpers.FirebaseHelper;
import mw.forwardplay.mdima.modules.InformationBarFragment;


public class AreaViewActivity extends SuperActivity {
    public final static String AREA_LOCATION = "area_location";
    public final static String AREA_NAME = "area_name";
    private static InformationBarFragment informationBarFragment;
    private DatabaseReference firebaseRef;
    private String location;
    private String area;
    private static String title, subtitle;
    private static int icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_view);
        firebaseRef = FirebaseHelper.getDbInstance().getReference("areas");
        Intent areaIntent = getIntent();
        area = areaIntent.getStringExtra(AREA_NAME);
        location = areaIntent.getStringExtra(AREA_LOCATION);
        setInformationBarFragment();
        showArea();
    }

    private void setInformationBarFragment()
    {
       informationBarFragment = (InformationBarFragment)
                getSupportFragmentManager()
                .findFragmentById(R.id.informationBar);
    }
    public static void setInformationBar(String titleParam, String subtitleParam, int iconParam)
    {
        title = titleParam;
        subtitle = subtitleParam;
        icon = iconParam;
    }

    public static void setViews()
    {
        informationBarFragment.setTitle(title);
        informationBarFragment.setSubtitle(subtitle);
        informationBarFragment.setIcon(icon);
        informationBarFragment.setViews();
    }

    private void showArea() {
        Query areaQuery = firebaseRef.child(location).child(area);
        areaQuery.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                StringBuilder areaInfo = new StringBuilder();
                Areas areaData = dataSnapshot.getValue(Areas.class);
                areaInfo.append(areaData.getRegion())
                        .append("\n")
                        .append(areaData.getLocation());

                AreaViewActivity.setInformationBar(
                   areaData.getArea(), areaInfo.toString(), R.drawable.information
                );
                AreaViewActivity.setViews();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
