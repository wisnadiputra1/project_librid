package com.uts.mobprog210040138;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.google.android.material.navigation.NavigationBarView;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    public static final int ACTION_HOME = R.id.action_home;
    public static final int ACTION_DASHBOARD = R.id.action_dashboard;
    public static final int ACTION_ABOUT = R.id.action_about_us;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi bottomNavigationView
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                if (item.getItemId() == ACTION_HOME) {
                    selectedFragment = new HomeFragment();
                } else if (item.getItemId() == ACTION_DASHBOARD) {
                    selectedFragment = new DashboardFragment();
                } else if (item.getItemId() == ACTION_ABOUT) {
                    selectedFragment = new AboutUsFragment();
                } else {
                    return false;
                }
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame_layout, selectedFragment)
                            .commit();
                    return true; // Return true when a fragment is selected
                } else {
                    return false; // Return false when no fragment is selected
                }
            }
        });
    }
}