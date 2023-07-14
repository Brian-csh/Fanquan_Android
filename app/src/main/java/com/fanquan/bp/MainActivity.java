package com.fanquan.bp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.bp.R;
import com.fanquan.bp.fragments.ChatFragment;
import com.fanquan.bp.fragments.ForumFragment;
import com.fanquan.bp.fragments.HomeFragment;
import com.fanquan.bp.fragments.PersonalFragment;
import com.fanquan.bp.fragments.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the fragment manager
        fragmentManager = getSupportFragmentManager();

        // Display the home fragment
        displayFragment(new HomeFragment());

        //add listener for the bottom navigation bar
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setLabelVisibilityMode(NavigationBarView.LABEL_VISIBILITY_UNLABELED);
        //set on selected item listener
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               Fragment fragment = null;
               int id = item.getItemId();
               if (id == R.id.action_home) {
                   fragment = new HomeFragment();
               } else if (id == R.id.action_forum) {
                   fragment = new ForumFragment();
               } else if (id == R.id.action_personal) {
                   fragment = new PersonalFragment();
               } else if (id == R.id.action_chat) {
                   fragment = new ChatFragment();
               } else if (id == R.id.action_settings) {
                   fragment = new SettingsFragment();
               }
               if (fragment == null) {
                   return false;
               } else {
                     displayFragment(fragment);
                     return true;
               }
           }
       });
    }

    private void displayFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragment, fragment);
        fragmentTransaction.commit();
    }
}