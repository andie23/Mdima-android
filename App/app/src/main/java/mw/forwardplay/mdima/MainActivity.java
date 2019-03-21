package mw.forwardplay.mdima;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends SuperActivity {
    private ListView mainOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        mainOptions = (ListView) findViewById(R.id.fixed_main_options);
        listViewOnClickListerner();
        super.onCreate(savedInstanceState);
    }

    public void listViewOnClickListerner()
    {
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
               switch(position)
               {
                   case 0:
                      Intent regionIntent = new Intent(MainActivity.this,
                              RegionActivity.class);
                      startActivity(regionIntent);
                      break;
                   case 1:
                       Intent areaViewIntent = new Intent(MainActivity.this,
                               AreaViewActivity.class);
                       startActivity(areaViewIntent);
                       break;
               }
            }
        };

        mainOptions.setOnItemClickListener(itemClickListener);

    }

}
