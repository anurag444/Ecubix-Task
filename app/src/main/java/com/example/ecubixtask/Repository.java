package com.example.ecubixtask;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.ecubixtask.data.Detail;

import java.util.List;

public class Repository {

    private EmployeeDao employeeDao;
    private LiveData<List<Detail>> allEmployees;

    public Repository(Application application){
        EmployeeDatabase database = EmployeeDatabase.getInstance(application);
        employeeDao = database.employeeDao();
        allEmployees = employeeDao.getAllEmployees();
    }

    public void insertAll(List<Detail> details){
        new InsertAllEmployees(employeeDao).execute(details);
    }

    public void delete(Detail detail){
        new DeleteEmployees(employeeDao).execute(detail);
    }

    public void deleteAll(){
        new DeleteAllEmployees(employeeDao).execute();
    }

    public void update(Detail detail){
        new UpdateEmployees(employeeDao).execute(detail);
    }

    public LiveData<Detail> getEmployeeById(String id){
        return employeeDao.getEmployeeById(id);
    }

    public LiveData<List<Detail>> getAllEmployees(){
        return allEmployees;
    }

    private static class InsertAllEmployees extends AsyncTask<List<Detail>, Void, Void>{

        private final EmployeeDao dao;

        private InsertAllEmployees(EmployeeDao dao){
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(List<Detail>... lists) {
            dao.insertAll(lists[0]);
            return null;
        }
    }

    private static class DeleteEmployees extends AsyncTask<Detail, Void, Void>{

        private EmployeeDao dao;

        private DeleteEmployees(EmployeeDao dao){
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Detail... details) {
            dao.delete(details[0]);
            return null;
        }
    }

    private static class UpdateEmployees extends AsyncTask<Detail, Void, Void>{

        private EmployeeDao dao;

        private UpdateEmployees(EmployeeDao dao){
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Detail... details) {
            dao.update(details[0]);
            return null;
        }
    }

    private static class DeleteAllEmployees extends AsyncTask<Void, Void, Void>{

        private EmployeeDao dao;

        private DeleteAllEmployees(EmployeeDao dao){
            this.dao = dao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllEmployees();
            return null;
        }
    }
}
