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
import com.fanquan.bp.EventActivity;
import com.fanquan.bp.adapters.EventRecViewAdapter;
import com.fanquan.bp.models.Event;
import com.fanquan.bp.utils.OnEventClickedListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalFragment extends Fragment {
    private RecyclerView todayRecView;
    private RecyclerView weekRecView;
    private OnEventClickedListener onEventClickedListener;
    public PersonalFragment() {
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
        View parentView = inflater.inflate(R.layout.fragment_personal, container, false);

        TextView accountNameText = parentView.findViewById(R.id.account_name_text);
        accountNameText.setText("CRK"); //@todo: get the account name

        Calendar calender = Calendar.getInstance();
        int day = calender.get(Calendar.DAY_OF_WEEK);
        String[] daysOfWeek = new String[]{"SUN.", "MON.", "TUE.", "WED.", "THU.", "FRI.", "SAT."};
        String todayDayOfWeek = daysOfWeek[day - 1];

        // Create a SimpleDateFormat object with the desired format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        // Get the current date
        Date currentDate = new Date();
        // Format the date to the desired format
        String formattedDate = dateFormat.format(currentDate);

        TextView dateText = parentView.findViewById(R.id.date_text);
        String displayDate = todayDayOfWeek + " " + formattedDate;
        dateText.setText(displayDate);

        //Add Button
        Button addButton = parentView.findViewById(R.id.personal_add_button);
        //set listener for the button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //jump to add event page
                Intent intent = new Intent(getActivity(), AddActivity.class);
                startActivity(intent);
            }
        });

        initOnEventClickedListener();

        todayRecView = parentView.findViewById(R.id.today_recycler);
        weekRecView = parentView.findViewById(R.id.week_recycler);

        ArrayList<Event> eventList = new ArrayList<Event>();
        eventList.add(new Event("羽毛球", "总体", "2023-2-12", "9:00-11:00"));
        eventList.add(new Event("篮球3v3", "紫荆篮球场", "2023-2-10", "13:00-14:00"));
        eventList.add(new Event("篮球5v5", "紫荆篮球场", "2023-1-20", "10:00-12:00"));
        eventList.add(new Event("排球", "北体", "2023-1-5", "14:00-16:00"));
        eventList.add(new Event("足球", "北体", "2023-1-8", "12:00-17:00"));

        displayTodayEvents(eventList);
        displayWeekEvents(eventList);

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

    private void displayTodayEvents(List<Event> eventList) {
        EventRecViewAdapter adapter = new EventRecViewAdapter(getActivity(), eventList);
        adapter.setListener(onEventClickedListener);
        todayRecView.setAdapter(adapter);
        todayRecView.setLayoutManager(new LinearLayoutManager(getActivity()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(todayRecView.getContext(),
                DividerItemDecoration.VERTICAL);
        todayRecView.addItemDecoration(dividerItemDecoration);
    }

    private void displayWeekEvents(List<Event> eventList) {
        EventRecViewAdapter adapter = new EventRecViewAdapter(getActivity(), eventList);
        adapter.setListener(onEventClickedListener);
        weekRecView.setAdapter(adapter);
        weekRecView.setLayoutManager(new LinearLayoutManager(getActivity()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(weekRecView.getContext(),
                DividerItemDecoration.VERTICAL);
        weekRecView.addItemDecoration(dividerItemDecoration);
    }
}