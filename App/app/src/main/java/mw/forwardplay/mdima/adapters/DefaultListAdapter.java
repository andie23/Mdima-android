package mw.forwardplay.mdima.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mw.forwardplay.mdima.R;


public class DefaultListAdapter extends RecyclerView.Adapter<DefaultListAdapter.ViewHolder> {

    private ListEventListerner eventListerner;
    private List<ListData> listData;
    public DefaultListAdapter(List<ListData> listData) {
        this.listData = listData;
    }

    interface ListEventListerner
    {
        void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        CardView cardView;
        public ViewHolder(CardView cardView)
        {
            super(cardView);
            this.cardView =  cardView;
        }
    }

    @Override
    public DefaultListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.default_list_card, parent, false);

        ViewHolder vh = new ViewHolder(cardView);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder vh, int position)
    {
        ListData dataSet = listData.get(position);
        CardView cardView = vh.cardView;
        TextView titleText = (TextView) cardView.findViewById(R.id.cardItemTitle);
        TextView descriptionText = (TextView) cardView.findViewById(R.id.cardItemDescription);

        titleText.setText(dataSet.getTitle());
        descriptionText.setText(dataSet.getDescription());

        final int itemPostion = position;
        if(eventListerner!=null)
        {
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    eventListerner.onClick(itemPostion);
                }
            });

        }
    }

    @Override
    public int getItemCount()
    {
        return listData.size();
    }

}
