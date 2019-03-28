package mw.forwardplay.mdima;

import android.os.Bundle;

import mw.forwardplay.mdima.modules.InformationBarFragment;
import mw.forwardplay.mdima.modules.RegionsFragment;
import mw.forwardplay.mdima.modules.SuperFragment;

public class DataListActivity extends SuperActivity {
    private InformationBarFragment informationBarFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);
        setInformationBarFragment();
        loadDefaultFragment();
    }

    public void setInformationBar(String title, String subtitle, int icon)
    {
        informationBarFragment.setTitle(title);
        informationBarFragment.setSubtitle(subtitle);
        informationBarFragment.setIcon(icon);
        informationBarFragment.setViews();
    }

    void setInformationBarFragment()
    {
        informationBarFragment = (InformationBarFragment)
                getSupportFragmentManager().findFragmentById(R.id.informationBar);
    }

    void loadDefaultFragment()
    {
        SuperFragment superFragment = (SuperFragment) getSupportFragmentManager().findFragmentById(
                R.id.fragment_container);

        superFragment.replaceFragment(new RegionsFragment());
    }
}
