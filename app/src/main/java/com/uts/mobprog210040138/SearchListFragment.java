package com.uts.mobprog210040138;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.uts.mobprog210040138.models.ModelAPIResBook;
import com.uts.mobprog210040138.models.ModelBook;

import java.util.List;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //Variabel buku
    private List<ModelBook> data2;
    private RecyclerView recyclerSearch;
    private RecycleViewSearchAdapter searchAdapter;
    private ModelAPIResBook result;
    private Context ctx;
    private View view;
    private SearchView searchView;
    private List<ModelBook> allBooks = new ArrayList<>(); // Declare and initialize the list
    private List<ModelBook> filteredBooks = new ArrayList<>(); // Declare and initialize the filtered list

    public SearchListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchListFragment newInstance(String param1, String param2) {
        SearchListFragment fragment = new SearchListFragment();
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
        View view = inflater.inflate(R.layout.fragment_search_list, container, false);

        //ini buat pindah ke dashboard

        // Temukan ImageButton dari layout
        imageButton = view.findViewById(R.id.imageButton4);
        //Inisialisasi id recyclerView dashboard
        recyclerSearch = view.findViewById(R.id.recyclerSearch);
        searchView = view.findViewById(R.id.SearchDashboard);
        //Mengatur data yang akan ditampilkan
        LinearLayoutManager manager = new LinearLayoutManager(ctx);
        recyclerSearch.setLayoutManager(manager);
        recyclerSearch.setHasFixedSize(true);
        // Tambahkan event listener untuk ImageButton
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kode yang akan dijalankan ketika ImageButton diklik
                // Panggil metode atau tindakan untuk membuka SearchListFragment
                openDashboardFragment();
            }
        });


        // Call searchBook() to set up search functionality
        searchBook();

        // Call searchData() to populate RecyclerView with data
        searchData();

        return view;
    }

    // Metode untuk membuka SearchListFragment
    private void openDashboardFragment() {
        // Buat instance dari SearchListFragment
        DashboaardFragment dashboaardFragment = new DashboaardFragment();

        // Ganti fragment di dalam container (contoh: menggunakan R.id.fragment_container)
        getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_search, dashboaardFragment)
                .addToBackStack(null)
                .commit();
    }


    private void searchBook() {

        if (searchView != null) {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    filterBook(s);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    filterBook(s);
                    return true;
                }
            });
        }


    }

    ApiInterfaceBook apiServices = APIClient.getClient().create(ApiInterfaceBook.class);

    public void searchData() {
        Call<ModelAPIResBook> getDataBooks = apiServices.getAllBook();

        getDataBooks.enqueue(new Callback<ModelAPIResBook>() {
            @Override
            public void onResponse(Call<ModelAPIResBook> call, Response<ModelAPIResBook> response) {
                if(response.code() != 200) {
                    Toast.makeText(getContext(), "code" + response.code(), Toast.LENGTH_SHORT).show();
                }else{
                    if (response.body() == null) {

                    }else {
                        result = response.body();
                        data2 = result.getData();
                        searchAdapter = new RecycleViewSearchAdapter(ctx, data2);
                        recyclerSearch.setAdapter(searchAdapter);
                        searchAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<ModelAPIResBook> call, Throwable t) {

            }
        });
    }

    private void filterBook(String query) {
        filteredBooks.clear();

        if (TextUtils.isEmpty(query)) {
            filteredBooks.addAll(data2);
        } else {
            query = query.toLowerCase().trim();

            for (ModelBook book : data2) {
                if (book.getTitle().toLowerCase().contains(query)) {
                    filteredBooks.add(book);
                }
            }
        }

        // Update the UI with the filtered list of books
        searchAdapter.notifyDataSetChanged();
    }
}