package com.fanquan.bp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bp.R;
import com.fanquan.bp.models.Event;
import com.fanquan.bp.utils.OnEventClickedListener;

import java.util.List;

public class EventRecViewAdapter extends RecyclerView.Adapter<EventRecViewAdapter.ViewHolder> {
    private List<Event> eventList;
    private Context context;
    private OnEventClickedListener listener;

    public EventRecViewAdapter(Context context, List<Event> eventList) {
        this.eventList = eventList;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView eventCard;
        private TextView titleText;
        private TextView detailsText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eventCard = itemView.findViewById(R.id.event_card);
            titleText = itemView.findViewById(R.id.event_title_text);
            detailsText = itemView.findViewById(R.id.event_details_text);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the layout for each item in the recycler view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //set the data for each item in the recycler view
        holder.titleText.setText(eventList.get(position).getTitle());

        String details = eventList.get(position).getLocation() + " | " + eventList.get(position).getTime();
        holder.detailsText.setText(details);
        holder.eventCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onEventClicked(eventList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public void setListener(OnEventClickedListener listener) {
        this.listener = listener;
    }
}
