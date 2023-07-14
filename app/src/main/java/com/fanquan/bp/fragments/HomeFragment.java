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
import android.widget.TextView;
import android.widget.Toast;

import com.example.bp.R;
import com.fanquan.bp.AddActivity;
import com.fanquan.bp.EventActivity;
import com.fanquan.bp.adapters.EventRecViewAdapter;
import com.fanquan.bp.models.Event;
import com.fanquan.bp.utils.OnEventClickedListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView eventRecView;
    private OnEventClickedListener onEventClickedListener;
    public HomeFragment() {
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
        View parentView = inflater.inflate(R.layout.fragment_home, container, false);

        //recyclerview
        eventRecView = parentView.findViewById(R.id.event_list_recycler);

        //set organization
        TextView orgText = parentView.findViewById(R.id.home_org_textview);
        orgText.setText("PKU");

        initOnEventClickedListener();

        SearchView searchView = parentView.findViewById(R.id.home_search);
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
        Button addButton = parentView.findViewById(R.id.home_add_button);
        //set listener for the button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //jump to add event page
                Intent intent = new Intent(getActivity(), AddActivity.class);
                startActivity(intent);
            }
        });

        //sample
        ArrayList<Event> eventList = new ArrayList<Event>();
        eventList.add(new Event("羽毛球", "总体，2023-2-12"));
        eventList.add(new Event("篮球3v3", "紫荆篮球场，2023-2-10"));
        eventList.add(new Event("篮球5v5", "紫荆篮球场，2023-1-20"));
        eventList.add(new Event("排球", "北体，2023-1-5"));

        displayActivities(eventList);

        return parentView;
    }

    private void initOnEventClickedListener() {
        onEventClickedListener = new OnEventClickedListener() {
            @Override
            public void onEventClicked(Event event) {
                Intent intent = new Intent(getActivity(), EventActivity.class);
                intent.putExtra("event", event); //News class implements serializable
                startActivity(intent);
            }
        };
    }

    private void setArticleList() {
        //obtain the articles from the server

    }

    private void displayActivities(List<Event> eventList) {
//        if (eventList.size() == 0)
//            Toast.makeText(getActivity(), "No available activity data.", Toast.LENGTH_SHORT).show();

        EventRecViewAdapter adapter = new EventRecViewAdapter(getActivity(), eventList);
        adapter.setListener(onEventClickedListener);
        eventRecView.setAdapter(adapter);
        eventRecView.setLayoutManager(new LinearLayoutManager(getActivity()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(eventRecView.getContext(),
                DividerItemDecoration.VERTICAL);
        eventRecView.addItemDecoration(dividerItemDecoration);
    }
}