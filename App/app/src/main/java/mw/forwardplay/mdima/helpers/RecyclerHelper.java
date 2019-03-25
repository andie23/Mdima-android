package mw.forwardplay.mdima.helpers;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import mw.forwardplay.mdima.adapters.DefaultListAdapter;
import mw.forwardplay.mdima.adapters.ListData;

public class RecyclerHelper {
    public interface OnClickItemList{
        void onClick(int index);
    }

    private RecyclerView recyclerView;
    private DefaultListAdapter adapter;

    public RecyclerHelper(RecyclerView recyclerView)
    {
        this.recyclerView = recyclerView;
    }

    public void setRecycler(Context context, List<ListData> listData,
                            OnClickItemList onClickItemList)
    {
        final OnClickItemList clickEvent = onClickItemList;
        adapter = new DefaultListAdapter(listData);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setEventListerner(new DefaultListAdapter.ListEventListerner() {
            @Override
            public void onClick(int position) {
                clickEvent.onClick(position);
            }
        });
    }

}
