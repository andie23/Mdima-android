package mw.forwardplay.mdima.commons;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import mw.forwardplay.mdima.R;

public class CommonToolbar {
    private static final int toolbarResource = R.id.toolbar;
    private void Toolbar(){}

    public static ActionBar getActionbar(AppCompatActivity activity) {
        Toolbar toolbar = (Toolbar) activity.findViewById(toolbarResource);
        activity.setSupportActionBar(toolbar);
        return activity.getSupportActionBar();
    }
}
