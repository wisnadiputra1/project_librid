package com.uts.mobprog210040138;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboaardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class DashboaardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public DashboaardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboaardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboaardFragment newInstance(String param1, String param2) {
        DashboaardFragment fragment = new DashboaardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    ImageButton imageButton;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboaard, container, false);

        //ini buat pindah ke search

        // Temukan ImageButton dari layout
        imageButton = view.findViewById(R.id.imageButton3);

        // Tambahkan event listener untuk ImageButton
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Panggil metode atau tindakan untuk membuka SearchListFragment
                openSearchListFragment();
            }
        });

        return view;
    }

    // Metode untuk membuka SearchListFragment
    private void openSearchListFragment() {
        // Buat instance dari SearchListFragment
        SearchListFragment searchListFragment = new SearchListFragment();

        // Ganti fragment di dalam container (contoh: menggunakan R.id.fragment_container)
        getParentFragmentManager().beginTransaction()
                .replace(R.id.dashboard_fragment, searchListFragment)
                .addToBackStack(null)
                .commit();
    }

}