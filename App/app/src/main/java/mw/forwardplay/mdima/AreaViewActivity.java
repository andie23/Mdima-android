package mw.forwardplay.mdima;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import mw.forwardplay.mdima.entities.Areas;


public class AreaViewActivity extends SuperActivity {
    public final static String AREA_LOCATION = "area_location";
    public final static String AREA_NAME = "area_name";
    private String area;
    private String location;
    private String group;
    private TextView title;
    private TextView subtitle;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_view);
        Intent areaViewIntent = getIntent();
        area = areaViewIntent.getStringExtra(AREA_NAME);
        location = areaViewIntent.getStringExtra(AREA_LOCATION);
        title = (TextView) findViewById(R.id.areaTitle);
        subtitle = (TextView) findViewById(R.id.areaSubtitle);
        progressBar = (ProgressBar) findViewById(R.id.spinner);
        progressBar.setVisibility(View.VISIBLE);
        showArea();
    }

    private void showArea() {
        Query areaQuery = fbAreasRef.child(location).child(area);
        areaQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                StringBuilder areaInfo = new StringBuilder();
                Areas areaData = dataSnapshot.getValue(Areas.class);
                title.setText(areaData.getArea());
                subtitle.setText(
                        areaInfo
                        .append(areaData.getRegion())
                        .append("\n")
                        .append(areaData.getLocation())
                        .toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        progressBar.setVisibility(View.GONE);
    }

}
