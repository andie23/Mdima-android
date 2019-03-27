package mw.forwardplay.mdima.adapters;

import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mw.forwardplay.mdima.R;

public class StaticMenuListAdapter extends DefaultListAdapter {
    public static final String ICON = "icon";

    public StaticMenuListAdapter(List<ListData>listData)
    {
        super(listData);
    }

    @Override
    public DefaultListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_menu_list_card, parent, false);

        ViewHolder vh = new ViewHolder(cardView);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder vh, final int position)
    {
        ListData data = listData.get(position);
        CardView cardView = vh.cardView;
        ImageView imageView = cardView.findViewById(R.id.cardImageView);
        TextView titleView = cardView.findViewById(R.id.icCardTitle);
        TextView subtitle = cardView.findViewById(R.id.icCardSubtitle);

        int icon = Integer.valueOf(data.params.get(ICON));

        imageView.setImageResource(icon);
        titleView.setText(data.getTitle());
        subtitle.setText(data.getDescription());
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

}
