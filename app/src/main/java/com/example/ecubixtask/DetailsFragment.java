package com.example.ecubixtask;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ecubixtask.data.Detail;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;
import java.util.Objects;

public class DetailsFragment extends Fragment {

    private EmployeeViewModel employeeViewModel;
    private TextInputEditText name, category, speciality, city, mobile, remarks;
    private MaterialButton update, delete;
    private Detail mEmployee;
    private ImageView back;

    private static final String TAG = "DetailsFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);

        initView(view);

        employeeViewModel = new ViewModelProvider(requireActivity()).get(EmployeeViewModel.class);

        if (getArguments() != null) {
            String value = getArguments().getString("key");

            employeeViewModel.getEmployeeById(value).observe(requireActivity(), new Observer<Detail>() {
                @Override
                public void onChanged(Detail employee) {
                    mEmployee = employee;
                    if (employee != null) updateUI(employee);
                }
            });
        }

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEmployee.setVarDrName(Objects.requireNonNull(name.getText()).toString());
                mEmployee.setVarCategory(Objects.requireNonNull(category.getText()).toString());
                mEmployee.setVarSpeciality(Objects.requireNonNull(speciality.getText()).toString());
                mEmployee.setVarCity(Objects.requireNonNull(city.getText()).toString());
                mEmployee.setVarMobileNo(Objects.requireNonNull(mobile.getText()).toString());
                mEmployee.setVarReqRemarks(Objects.requireNonNull(remarks.getText()).toString());
                employeeViewModel.update(mEmployee);
                Toast.makeText(requireContext(), "Employee Updated", Toast.LENGTH_SHORT).show();
                closeFragment();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                employeeViewModel.delete(mEmployee);
                Toast.makeText(requireContext(), "Employee Deleted", Toast.LENGTH_SHORT).show();
                closeFragment();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeFragment();
            }
        });

        return view;
    }

    private void closeFragment() {
        getActivity().onBackPressed();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "OnResume");
    }

    private void initView(View view) {
        name = view.findViewById(R.id.employee_name);
        category = view.findViewById(R.id.employee_category);
        speciality = view.findViewById(R.id.employee_speciality);
        city = view.findViewById(R.id.employee_city);
        mobile = view.findViewById(R.id.employee_mobile);
        remarks = view.findViewById(R.id.employee_remarks);
        update = view.findViewById(R.id.update);
        delete = view.findViewById(R.id.delete);
        back = view.findViewById(R.id.back);
    }

    private void updateUI(Detail employee) {
        name.setText(employee.getVarEmpName());
        category.setText(employee.getVarCategory());
        speciality.setText(employee.getVarSpeciality());
        city.setText(employee.getVarCity());
        mobile.setText(employee.getVarMobileNo());
        remarks.setText(employee.getVarReqRemarks());
    }
}