package mw.forwardplay.mdima.modules;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import mw.forwardplay.mdima.R;
import mw.forwardplay.mdima.adapters.ListData;
import mw.forwardplay.mdima.helpers.FirebaseHelper;
import mw.forwardplay.mdima.helpers.RecyclerHelper;

public class SuperFragment extends Fragment {
    protected RecyclerView recyclerView;
    protected AppCompatActivity activity;
    protected FirebaseDatabase firebaseDatabase;

    interface ListEntityData {
        ListData onSetListData(DataSnapshot snapshot, ListData listData);
        void onClick(int index);
    }

    @Override
    public void onCreate(Bundle savedInstanceBundle)
    {
        super.onCreate(savedInstanceBundle);
        activity = (AppCompatActivity) getActivity();
        firebaseDatabase = FirebaseHelper.getDbInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_super, container, false);
        recyclerView = view.findViewById(R.id.listRecycler);
        return view;
    }

    void setViewItemList(List<ListData> listData, RecyclerHelper.OnClickItemList clickEvent)
    {
        RecyclerHelper recyclerHelper = new RecyclerHelper(recyclerView);
        recyclerHelper.setRecycler(activity, listData, clickEvent);
    }

    protected void setRecyclerListData(DatabaseReference dbRef, final ListEntityData listEntityData) {
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<ListData> entityListData = new ArrayList<>();
                for(DataSnapshot snapshot: dataSnapshot.getChildren())
                {
                    entityListData.add(listEntityData.onSetListData(snapshot, new ListData()));
                }
                setViewItemList(entityListData, new RecyclerHelper.OnClickItemList(){
                    @Override
                    public void onClick(int index)
                    {
                        listEntityData.onClick(index);
                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
