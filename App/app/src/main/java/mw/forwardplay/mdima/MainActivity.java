package mw.forwardplay.mdima;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import mw.forwardplay.mdima.cache.MdimaDatabase;
import mw.forwardplay.mdima.cache.RegionEntity;

public class MainActivity extends AppCompatActivity {
    private ListView mainOptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewOnClickListerner();
    }

    public void listViewOnClickListerner()
    {
        mainOptions = (ListView) findViewById(R.id.fixed_main_options);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               if(i == 0){
                   Intent areaViewIntent = new Intent(MainActivity.this, AreaViewActivity.class);
                   startActivity(areaViewIntent);
               }
            }
        };

        mainOptions.setOnItemClickListener(itemClickListener);

    }

}
