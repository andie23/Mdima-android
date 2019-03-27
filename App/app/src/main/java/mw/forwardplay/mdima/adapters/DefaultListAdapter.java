package mw.forwardplay.mdima.adapters;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mw.forwardplay.mdima.R;


public class DefaultListAdapter extends RecyclerView.Adapter<DefaultListAdapter.ViewHolder> {
    public static final String SET_SELECT_ICON = "set_select_icon";
    public static final int SELECT_ICON_VISIBLE = 1;
    public static final int SELECT_ICON_INVISIBLE = 0;

    private ListEventListerner eventListerner;
    private List<ListData> listData;
    public DefaultListAdapter(List<ListData> listData) {
        this.listData = listData;
    }

    public interface ListEventListerner
    {
        void onClick(int position);
    }

    public void setEventListerner(ListEventListerner listerner)
    {
        eventListerner = listerner;
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
    public void onBindViewHolder(ViewHolder vh, final int position)
    {
        ListData dataSet = listData.get(position);
        CardView cardView = vh.cardView;
        TextView titleText = cardView.findViewById(R.id.cardItemTitle);
        TextView descriptionText =  cardView.findViewById(R.id.cardItemDescription);
        ImageView selectIcon = cardView.findViewById(R.id.cardSelectIcon);

        titleText.setText(dataSet.getTitle());
        descriptionText.setText(dataSet.getDescription());

        if(dataSet.params.containsKey(SET_SELECT_ICON) &&
                Integer.valueOf(dataSet.params.get(SET_SELECT_ICON)) == SELECT_ICON_INVISIBLE)
        {
            selectIcon.setVisibility(selectIcon.INVISIBLE);
        }else{
            selectIcon.setVisibility(selectIcon.VISIBLE);
        }

        if(eventListerner!=null)
        {
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    eventListerner.onClick(position);
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
