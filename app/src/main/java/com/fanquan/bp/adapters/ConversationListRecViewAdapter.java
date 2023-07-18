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
import com.fanquan.bp.models.ConversationPreview;
import com.fanquan.bp.utils.OnConversationClickedListener;

import java.util.List;

public class ConversationListRecViewAdapter extends RecyclerView.Adapter<ConversationListRecViewAdapter.ViewHolder> {
    private List<ConversationPreview> conversationList;
    private Context context;
    private OnConversationClickedListener listener;

    public ConversationListRecViewAdapter(Context context, List<ConversationPreview> conversationList) {
        this.conversationList = conversationList;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView conversationCard;
        private TextView nameText;
        private TextView lastMsgText;
        public ViewHolder(View itemView) {
            super(itemView);
            conversationCard = itemView.findViewById(R.id.conversation_card);
            nameText = itemView.findViewById(R.id.conversation_name_text);
            lastMsgText = itemView.findViewById(R.id.last_msg_text);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the layout for each item in the recycler view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_conversation, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //set the data for each item in the recycler view
        holder.nameText.setText(conversationList.get(position).getName());
        holder.lastMsgText.setText(conversationList.get(position).getLastMsg());
        holder.conversationCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onEventClicked(conversationList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return conversationList.size();
    }

    public void setListener (OnConversationClickedListener listener) {
        this.listener = listener;
    }
}
