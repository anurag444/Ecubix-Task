
package com.example.ecubixtask.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("Status")
    @Expose
    private List<Status> status = null;
    @SerializedName("Details")
    @Expose
    private List<Detail> details = null;
    @SerializedName("lstDrAdditionCityDetails")
    @Expose
    private Object lstDrAdditionCityDetails;
    @SerializedName("lstDrAdditionHospitalDetails")
    @Expose
    private Object lstDrAdditionHospitalDetails;

    public List<Status> getStatus() {
        return status;
    }

    public void setStatus(List<Status> status) {
        this.status = status;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public Object getLstDrAdditionCityDetails() {
        return lstDrAdditionCityDetails;
    }

    public void setLstDrAdditionCityDetails(Object lstDrAdditionCityDetails) {
        this.lstDrAdditionCityDetails = lstDrAdditionCityDetails;
    }

    public Object getLstDrAdditionHospitalDetails() {
        return lstDrAdditionHospitalDetails;
    }

    public void setLstDrAdditionHospitalDetails(Object lstDrAdditionHospitalDetails) {
        this.lstDrAdditionHospitalDetails = lstDrAdditionHospitalDetails;
    }

}
