package com.fanquan.bp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bp.R;
import com.fanquan.bp.models.Event;

public class EventActivity extends AppCompatActivity {
    private Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Intent intent = getIntent();
        event = (Event) intent.getSerializableExtra("event");

        displayContent();
    }

    private void displayContent() {
        String title = event.getTitle();
        String location = event.getLocation();
        String time = event.getTime();

        //display it on the components
        TextView tvTitle = findViewById(R.id.event_activity_title_text);
        TextView tvDetails = findViewById(R.id.event_activity_details_text);

        tvTitle.setText(title);
        tvDetails.setText("Location: " + location + "\n" + "Time: " + time);
    }
}