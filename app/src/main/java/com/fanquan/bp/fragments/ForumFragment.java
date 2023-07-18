package com.fanquan.bp.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bp.R;
import com.fanquan.bp.AddActivity;
import com.fanquan.bp.EventActivity;
import com.fanquan.bp.adapters.TopicRecViewAdapter;
import com.fanquan.bp.models.Topic;
import com.fanquan.bp.utils.OnTopicClickedListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ForumFragment extends Fragment {

    private RecyclerView topicRecView;
    private OnTopicClickedListener onTopicClickedListener;

    public ForumFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ForumFragment.
     */
    // TODO: Rename and change types and number of parameters
//    public static ForumFragment newInstance(String param1, String param2) {
//        ForumFragment fragment = new ForumFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_forum, container, false);

        topicRecView = parentView.findViewById(R.id.topic_list_recycler);

        //@todo: set the background image and text for announcement/ads

        initOnTopicClickedListener();

        SearchView searchView = parentView.findViewById(R.id.forum_search);
        //implement listener for searchview

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //when user submit the query
            @Override
            public boolean onQueryTextSubmit(String query) {
                //pull the corresponding articles
                return false;
            }

            //when user type in the searchview
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        //@todo: filter

        //Add Button
        Button addButton = parentView.findViewById(R.id.forum_add_button);
        //set listener for the button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //jump to add event page
                Intent intent = new Intent(getActivity(), AddActivity.class);
                startActivity(intent);
            }
        });


        //sample data
        ArrayList<Topic> topicList = new ArrayList<Topic>();
        topicList.add(new Topic("网友都用什么球拍", "羽毛球区"));
        topicList.add(new Topic("如何评价桃李三层云南菜", "清华大学"));
        topicList.add(new Topic("请问私家车可以进校吗？怎么报备？", "清华大学"));
        topicList.add(new Topic("abcdefg", "hijklmn"));
        topicList.add(new Topic("qwert", "asdf"));

        displayTopics(topicList);

        return parentView;
    }

    private void displayTopics(List<Topic> topicList) {
        TopicRecViewAdapter adapter = new TopicRecViewAdapter(getActivity(), topicList);
        adapter.setListener(onTopicClickedListener);
        topicRecView.setAdapter(adapter);
        topicRecView.setLayoutManager(new LinearLayoutManager(getActivity()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(topicRecView.getContext(),
                DividerItemDecoration.VERTICAL);
        topicRecView.addItemDecoration(dividerItemDecoration);
    }

    private void initOnTopicClickedListener() {
        onTopicClickedListener = new OnTopicClickedListener() {
            @Override
            public void onEventClicked(Topic topic) {
//                Intent intent = new Intent(getActivity(), EventActivity.class);
//                intent.putExtra("event", event); //News class implements serializable
//                startActivity(intent);
            }
        };
    }
}