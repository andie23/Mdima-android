package mw.forwardplay.mdima.modules;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import mw.forwardplay.mdima.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformationBarFragment extends Fragment {
    protected String title, subtitle;
    protected int icon;
    protected TextView titleTv, subtitleTv;
    protected ImageView iconIv;

    public InformationBarFragment() {
        // Required empty public constructor
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setSubtitle(String subtitle){
        this.subtitle = subtitle;
    }

    public void setIcon(int icon)
    {
        this.icon = icon;
    }

    public void setViews()
    {
        titleTv.setText(title);
        subtitleTv.setText(subtitle);
        iconIv.setImageResource(icon);
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_information_bar, container, false);
        titleTv = layout.findViewById(R.id.informationBarTitle);
        subtitleTv = layout.findViewById(R.id.informationBarSubtitle);
        iconIv = layout.findViewById(R.id.informationBarIcon);
        return layout;
    }
}
