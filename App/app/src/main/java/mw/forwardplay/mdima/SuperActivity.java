package mw.forwardplay.mdima;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import mw.forwardplay.mdima.adapters.DefaultListAdapter;
import mw.forwardplay.mdima.adapters.ListData;

public abstract class SuperActivity extends AppCompatActivity {
    private static final int toolbarRes = R.id.toolbar;
    private static final int menuResource = R.menu.toolbar_default;
    protected RecyclerView recyclerView;
    protected static FirebaseDatabase firebaseDatabase;
    protected static DatabaseReference fbRegionsRef;
    protected static DatabaseReference fbLocationsRef;
    protected static DatabaseReference fbAreasRef;
    protected static DatabaseReference fbSchedulesRef;
    protected static DatabaseReference fbGroupsRef;
    protected interface OnClickItemList{
        void onClick(int position);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(toolbarRes);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.drawable.logo);
        recyclerView = (RecyclerView) findViewById(R.id.defaultRecycler);
        if(firebaseDatabase==null){
            firebaseDatabase = FirebaseDatabase.getInstance();
            firebaseDatabase.setPersistenceEnabled(true);
        }
        fbRegionsRef = firebaseDatabase.getReference("/regions");
        fbLocationsRef = firebaseDatabase.getReference("/locations");
        fbAreasRef = firebaseDatabase.getReference("/areas");
        fbSchedulesRef = firebaseDatabase.getReference("/schedules");
        fbGroupsRef = firebaseDatabase.getReference("/groups");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(menuResource, menu);
        return super.onCreateOptionsMenu(menu);
    }

    void setViewItemList(List<ListData> listData, OnClickItemList clickEvent)
    {
        final OnClickItemList itemClick = clickEvent;
        DefaultListAdapter adapter = new DefaultListAdapter(listData);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layout);
        recyclerView.setAdapter(adapter);
        adapter.setEventListerner(new DefaultListAdapter.ListEventListerner() {
            @Override
            public void onClick(int position) {
                itemClick.onClick(position);
            }
        });
    }
}
