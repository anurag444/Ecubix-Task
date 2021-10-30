package com.example.ecubixtask;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecubixtask.data.Data;
import com.example.ecubixtask.data.Detail;
import com.example.ecubixtask.retrofit.EmployeeAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private EmployeeViewModel employeeViewModel;
    private RecyclerView employeeList;
    private SharedPreferences prefs;
    private ImageView refresh;
    private SearchView searchView;
    private EmployeeListAdapter adapter;
    private TextView emptyList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_home, container, false);

        init(view);

        //Set Data only for the first time
        prefs = requireContext().getSharedPreferences("prefs", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);
        if (firstStart){
            getEmployeeData();
        }

        //Set Data to the Recycler View
        setEmployeeData();

        refresh.setOnClickListener(v -> refreshList());

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return view;
    }


    private void init(View view) {
        employeeList = view.findViewById(R.id.employee_list);
        searchView = view.findViewById(R.id.search_view);
        employeeViewModel = new ViewModelProvider(requireActivity()).get(EmployeeViewModel.class);
        refresh = view.findViewById(R.id.refresh);
        emptyList = view.findViewById(R.id.empty_list);
        adapter = new EmployeeListAdapter(getContext());
    }

    private void refreshList() {
        closeKeyboard();
        employeeViewModel.deleteAll();
        Toast.makeText(requireContext(), "Data Updated", Toast.LENGTH_SHORT).show();
        getEmployeeData();
    }

    private void setEmployeeData() {
        employeeList.setLayoutManager(new LinearLayoutManager(getContext()));
        employeeList.setAdapter(adapter);
        employeeViewModel.getAllEmployees().observe(requireActivity(), new Observer<List<Detail>>() {
            @Override
            public void onChanged(List<Detail> details) {
                if (details.size() == 0){
                    employeeList.setVisibility(View.GONE);
                    emptyList.setVisibility(View.VISIBLE);
                }else{
                    employeeList.setVisibility(View.VISIBLE);
                    emptyList.setVisibility(View.GONE);
                }
                adapter.setEmployees(details);
            }
        });
    }

    private void closeKeyboard()
    {
        // this will give us the view
        // which is currently focus
        // in this layout
        View view = requireActivity().getCurrentFocus();

        // if nothing is currently
        // focus then this will protect
        // the app from crash
        if (view != null) {

            // now assign the system
            // service to InputMethodManager
            InputMethodManager manager
                    = (InputMethodManager)
                    requireContext().getSystemService(
                            Context.INPUT_METHOD_SERVICE);
            manager
                    .hideSoftInputFromWindow(
                            view.getWindowToken(), 0);
        }
    }

    private void getEmployeeData() {

        Call<Data> dataCall = EmployeeAPI.getService().getData();
        dataCall.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Data data = response.body();
                if (data != null) {
                    employeeViewModel.insertAll(data.getDetails());
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(getContext(), "Failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        prefs = requireActivity().getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();
    }
}