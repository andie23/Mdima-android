package mw.forwardplay.mdima;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import mw.forwardplay.mdima.adapters.ListData;
import mw.forwardplay.mdima.helpers.FirebaseHelper;
import mw.forwardplay.mdima.helpers.RecyclerHelper;

public abstract class SuperActivity extends AppCompatActivity {
    private String activityToolbarTitle;
    private static final int toolbarRes = R.id.toolbar;
    private static final int menuResource = R.menu.toolbar_default;
    protected RecyclerView recyclerView;
    protected static FirebaseDatabase firebaseDatabase;
    protected static DatabaseReference fbRegionsRef;
    protected static DatabaseReference fbLocationsRef;
    protected static DatabaseReference fbAreasRef;
    protected static DatabaseReference fbSchedulesRef;
    protected static DatabaseReference fbGroupsRef;

    @Override
    protected  void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int resourceId)
    {
        super.setContentView(resourceId);
        Toolbar toolbar = findViewById(toolbarRes);
        setSupportActionBar(toolbar);
        try{
            ActionBar actionbar = getSupportActionBar();
            actionbar.setIcon(R.drawable.logo);
        }catch (Exception error){
            Log.d("Toolbar Error", "You may have forgotten to include the toolbar layout" +
                    " in this activity's layout file.... check that buddy");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(menuResource, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
