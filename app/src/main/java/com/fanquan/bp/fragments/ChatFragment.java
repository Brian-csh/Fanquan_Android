package com.fanquan.bp.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.bp.R;
import com.fanquan.bp.AddActivity;
import com.fanquan.bp.adapters.ConversationListRecViewAdapter;
import com.fanquan.bp.models.ConversationPreview;
import com.fanquan.bp.models.Topic;
import com.fanquan.bp.utils.OnConversationClickedListener;
import com.fanquan.bp.utils.OnTopicClickedListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {
    private RecyclerView conversationListRecView;
    private OnConversationClickedListener onConversationClickedListener;
    public ChatFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_chat, container, false);

        TextView accountNameText = parentView.findViewById(R.id.chat_account_name_text);
        accountNameText.setText("CRK");

        conversationListRecView = parentView.findViewById(R.id.conversation_list_recycler);
        ArrayList<ConversationPreview> conversationList = new ArrayList<ConversationPreview>();
        conversationList.add(new ConversationPreview("", "John Doe", "Hello!"));
        conversationList.add(new ConversationPreview("", "Jane Doe", "Hi!"));
        conversationList.add(new ConversationPreview("", "Jimmy Doe", "Ok"));
        conversationList.add(new ConversationPreview("", "Jenny Doe", "Let's meet later, ok?"));
        conversationList.add(new ConversationPreview("", "Joan Doe", "No way!"));
        displayConversationList(conversationList);

        Button addButton = parentView.findViewById(R.id.chat_add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddActivity.class);
                startActivity(intent);
            }
        });

        return parentView;
    }

    private void displayConversationList(List<ConversationPreview> conversationList) {
        //set up recycler view
        ConversationListRecViewAdapter adapter = new ConversationListRecViewAdapter(getActivity(), conversationList);
        conversationListRecView.setAdapter(adapter);
        conversationListRecView.setLayoutManager(new LinearLayoutManager(getContext()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(conversationListRecView.getContext(),
                DividerItemDecoration.VERTICAL);
        conversationListRecView.addItemDecoration(dividerItemDecoration);
    }

    private void initOnConversationClickedListener() {
        onConversationClickedListener = new OnConversationClickedListener() {
            @Override
            public void onEventClicked(ConversationPreview conversationPreview) {
//                Intent intent = new Intent(getActivity(), EventActivity.class);
//                intent.putExtra("event", event); //News class implements serializable
//                startActivity(intent);
            }
        };
    }
}