package mw.forwardplay.mdima;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import mw.forwardplay.mdima.modules.RegionsFragment;
import mw.forwardplay.mdima.modules.SuperFragment;

public class DataListActivity extends SuperActivity {
    private TextView tvTitle, tvSubtitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);
        tvTitle = findViewById(R.id.fragmentTitle);
        tvSubtitle = findViewById(R.id.fragmentSubtitle);
        setDefaultFragment();
    }

    public void setTitle(String title)
    {
        tvTitle.setText(title);
    }

    public void setSubtitle(String subtitle)
    {
        tvSubtitle.setText(subtitle);
    }

    void setDefaultFragment()
    {
        SuperFragment superFragment = (SuperFragment) getSupportFragmentManager().findFragmentById(
                R.id.fragment_container);

        superFragment.replaceFragment(new RegionsFragment());
    }
}
