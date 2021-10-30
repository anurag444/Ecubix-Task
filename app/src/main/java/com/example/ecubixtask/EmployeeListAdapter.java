package com.example.ecubixtask;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecubixtask.data.Detail;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.ViewHolder> implements Filterable {

    private List<Detail> employees = new ArrayList<>();
    private List<Detail> fullEmployees;
    private Context context;

    EmployeeListAdapter(Context context){
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Detail employee = employees.get(position);

        holder.employeeName.setText(employee.getVarEmpName());  
        StringBuilder details = new StringBuilder();
        if (!employee.getVarCategory().isEmpty()) details.append(employee.getVarCategory());
        if (!employee.getVarSpeciality().isEmpty()) details.append(" | ").append(employee.getVarSpeciality());
        if (!employee.getVarCity().isEmpty()) details.append(" | ").append(employee.getVarCity());
        holder.employeeDetails.setText(details);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) context;
                Fragment myFragment = new DetailsFragment();
                Bundle args = new Bundle();
                args.putString("key", employee.getVarEmpCode());
                myFragment.setArguments(args);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, myFragment).addToBackStack(null).commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public void setEmployees(List<Detail> employees){
        this.employees = employees;
        fullEmployees = new ArrayList<>(employees);
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
            return employeeFilter;
    }

    private Filter employeeFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Detail> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(fullEmployees);
            }else {
                String pattern = constraint.toString().toLowerCase().trim();

                for (Detail detail : fullEmployees){
                    if (detail.getVarDrName().toLowerCase().contains(pattern) || detail.getVarCity().toLowerCase().contains(pattern)){
                        filteredList.add(detail);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            employees.clear();
            employees.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView employeeName, employeeDetails;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            employeeName = itemView.findViewById(R.id.employee_name);
            employeeDetails = itemView.findViewById(R.id.details);
        }
    }
}
