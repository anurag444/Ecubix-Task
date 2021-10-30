package com.example.ecubixtask.retrofit;

import com.example.ecubixtask.data.Data;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class EmployeeAPI {

    private static final String url = "https://services85.ecubix.com/ECPMobileWebService_Ver590/ecpMobileToWebSync.asmx/";

    public static EmployeeService service = null;

    public static EmployeeService getService(){
        if (service == null){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            service = retrofit.create(EmployeeService.class);
        }

        return service;
    }

    public interface EmployeeService{
        @GET("Get_DrAdditionRequestDetails?fk_EmpGLCode=729&varClientName=VCS_CQA")
        Call<Data> getData();
    }


}
