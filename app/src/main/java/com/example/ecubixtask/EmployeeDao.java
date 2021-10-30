package com.example.ecubixtask;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ecubixtask.data.Detail;

import java.util.List;

@Dao
public interface EmployeeDao {

    @Insert
    void insertAll(List<Detail> details);

    @Update
    void update(Detail detail);

    @Delete
    void delete(Detail detail);

    @Query("DELETE FROM employee_table")
    void deleteAllEmployees();

    @Query("SELECT * FROM employee_table")
    LiveData<List<Detail>> getAllEmployees();

    @Query("SELECT * FROM employee_table WHERE varEmpCode = :id")
    LiveData<Detail> getEmployeeById(String id);
}
