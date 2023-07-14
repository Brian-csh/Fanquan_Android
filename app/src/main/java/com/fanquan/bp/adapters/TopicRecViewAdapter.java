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
import com.fanquan.bp.models.Topic;
import com.fanquan.bp.utils.OnTopicClickedListener;

import java.util.List;

public class TopicRecViewAdapter extends RecyclerView.Adapter<TopicRecViewAdapter.ViewHolder> {
    private List<Topic> topicList;
    private Context context;
    private OnTopicClickedListener listener;

    public TopicRecViewAdapter(Context context, List<Topic> topicList) {
        this.topicList = topicList;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView topicCard;
        private TextView titleText;
        private TextView categoryText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            topicCard = itemView.findViewById(R.id.topic_card);
            titleText = itemView.findViewById(R.id.topic_title_text);
            categoryText = itemView.findViewById(R.id.topic_category_text);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the layout for each item in the recycler view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //set the data for each item in the recycler view
        holder.titleText.setText(topicList.get(position).getTitle());
        holder.categoryText.setText(topicList.get(position).getCategory());
        holder.topicCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onEventClicked(topicList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }

    public void setListener(OnTopicClickedListener listener) {
        this.listener = listener;
    }
}
