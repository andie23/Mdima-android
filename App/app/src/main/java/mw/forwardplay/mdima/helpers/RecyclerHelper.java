package mw.forwardplay.mdima.helpers;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import mw.forwardplay.mdima.adapters.DefaultListAdapter;
import mw.forwardplay.mdima.adapters.ListData;
import mw.forwardplay.mdima.adapters.StaticMenuListAdapter;

public class RecyclerHelper {
    public interface OnClickItemList{ void onClick(int index); }
    private RecyclerView recyclerView;
    public DefaultListAdapter adapter;

    public RecyclerHelper(RecyclerView recyclerView) { this.recyclerView = recyclerView; }

    private void setRecycler(DefaultListAdapter adapter, Context context,
            OnClickItemList onClickItemList)
    {
        final OnClickItemList clickEvent = onClickItemList;
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

    public void setDefaultRecycler(Context context, List<ListData> listData,
                                   OnClickItemList onClickItemList)
    {
        setRecycler(new DefaultListAdapter(listData), context, onClickItemList);
    }

    public void setStaticMenuRecycler(Context context, List<ListData> listData,
          OnClickItemList onClickItemList)
    {
        setRecycler(new StaticMenuListAdapter(listData), context, onClickItemList);
    }

}
