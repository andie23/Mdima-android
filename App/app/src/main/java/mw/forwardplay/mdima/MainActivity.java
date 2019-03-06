package mw.forwardplay.mdima;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mw.forwardplay.mdima.cache.MdimaDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MdimaDatabase dbInstance = MdimaDatabase.getInstance(this);
    }

    public void openPrimaryLocation(View view)
    {
        Intent areaViewIntent = new Intent(MainActivity.this, AreaViewActivity.class);
        startActivity(areaViewIntent);
    }
}
