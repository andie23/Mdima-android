package mw.forwardplay.mdima;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import mw.forwardplay.mdima.cache.MdimaDatabase;
import mw.forwardplay.mdima.cache.RegionEntity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MdimaDatabase dbInstance = MdimaDatabase.getInstance(this);
        Log.d("MDIM DATABASE", dbInstance.areaDao().fetchAll().toString());
    }

    public void openPrimaryLocation(View view)
    {
        Intent areaViewIntent = new Intent(MainActivity.this, AreaViewActivity.class);
        startActivity(areaViewIntent);
    }
}
