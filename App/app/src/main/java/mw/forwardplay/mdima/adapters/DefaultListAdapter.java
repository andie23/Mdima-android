package mw.forwardplay.mdima.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mw.forwardplay.mdima.R;


public class DefaultListAdapter extends RecyclerView.Adapter<DefaultListAdapter.ViewHolder> {
    public class ListData{
        private int id;
        private String title;
        private String description;

        public int getId() { return id; }
        public String getDescription() { return description; }
        public String getTitle() { return title; }
        public void setDescription(String description) { this.description = description; }
        public void setTitle(String title) { this.title = title; }
        public void setId(int id) { this.id = id; }
    }

    private List<ListData> listData;

    public void DefaultListAdapter(List<ListData> dataSet)
    {
        this.listData = dataSet;
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

        titleText.setText(dataSet.title);
        descriptionText.setText(dataSet.description);
    }

    @Override
    public int getItemCount()
    {
        return listData.size();
    }

}
