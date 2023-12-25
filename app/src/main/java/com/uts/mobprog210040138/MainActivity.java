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

    public static final int ACTION_DASHBOARD = R.id.dashboard;
    public static final int ACTION_MEMBER = R.id.members;
    public static final int ACTION_BOOKS = R.id.books;
    public static final int ACTION_LOANS = R.id.loans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi bottomNavigationView
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = new DashboaardFragment();

                if (item.getItemId() == ACTION_DASHBOARD) {
                    selectedFragment = new DashboaardFragment();
                } else if (item.getItemId() == ACTION_MEMBER) {
                    selectedFragment = new MembersFragment();
                } else if (item.getItemId() == ACTION_BOOKS) {
                    selectedFragment = new BooksFragment();
                } else if (item.getItemId() == ACTION_LOANS) {
                    selectedFragment = new LoansFragment();
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

        //halaman default sebelum memilih bottom navbar
        bottomNavigationView.setSelectedItemId(ACTION_DASHBOARD);
    }
}