package mw.forwardplay.mdima;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public abstract class SuperActivity extends AppCompatActivity {
    private static final int toolbarRes = R.id.toolbar;
    private static final int menuResource = R.menu.toolbar_default;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(toolbarRes);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(menuResource, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
