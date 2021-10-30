package com.example.ecubixtask;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.ecubixtask.data.Detail;

import java.util.List;

public class EmployeeViewModel extends AndroidViewModel {

    private Repository repository;
    private LiveData<List<Detail>> allEmployees;
    public EmployeeViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        allEmployees = repository.getAllEmployees();
    }

    public void insertAll(List<Detail> employees){
        repository.insertAll(employees);
    }

    public void update(Detail detail){
        repository.update(detail);
    }

    public void delete(Detail detail){
        repository.delete(detail);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    public LiveData<List<Detail>> getAllEmployees(){
        return allEmployees;
    }

    public LiveData<Detail> getEmployeeById(String id){
        return repository.getEmployeeById(id);
    }
}
