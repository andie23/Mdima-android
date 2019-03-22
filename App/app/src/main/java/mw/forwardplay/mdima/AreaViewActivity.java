package mw.forwardplay.mdima;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class AreaViewActivity extends SuperActivity {
    public final static String AREA_VIEW_BY_ID = "area_view_by_id";
    private int areaId;
    private String groupName;
    private TextView locationName;
    private TextView blackoutDate;
    private TextView startingTime;
    private TextView finishingTime;
    private TextView numberOfBlackouts;
    private TextView averageDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_area_view);
        locationName = (TextView) findViewById(R.id.locationName);
        numberOfBlackouts = (TextView) findViewById(R.id.areaNumberOfBlackouts);
        averageDuration = (TextView) findViewById(R.id.areaAverageHours);

        Intent areaViewIntent = getIntent();
        areaId = areaViewIntent.getIntExtra(AREA_VIEW_BY_ID, 0);
        super.onCreate(savedInstanceState);

    }

}
