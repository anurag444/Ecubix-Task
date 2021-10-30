
package com.example.ecubixtask.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "employee_table")
public class Detail {

    @SerializedName("varDrName")
    @Expose
    private String varDrName;
    @SerializedName("varCategory")
    @Expose
    private String varCategory;
    @SerializedName("varSpeciality")
    @Expose
    private String varSpeciality;
    @SerializedName("varCity")
    @Expose
    private String varCity;
    @SerializedName("varReqDate")
    @Expose
    private String varReqDate;
    @SerializedName("varStatus")
    @Expose
    private String varStatus;
    @SerializedName("varAppDate")
    @Expose
    private String varAppDate;
    @SerializedName("varLatestStatus")
    @Expose
    private String varLatestStatus;
    @SerializedName("varStatusUpdatedBy")
    @Expose
    private String varStatusUpdatedBy;
    @NonNull
    @PrimaryKey
    @SerializedName("varEmpCode")
    @Expose
    private String varEmpCode;
    @SerializedName("varEmpName")
    @Expose
    private String varEmpName;
    @SerializedName("varReqRemarks")
    @Expose
    private String varReqRemarks;
    @SerializedName("varAppRemarks")
    @Expose
    private String varAppRemarks;
    @SerializedName("varMobileNo")
    @Expose
    private String varMobileNo;
    @SerializedName("varDrReqCode")
    @Expose
    private String varDrReqCode;

    public Detail(String varDrName, String varCategory, String varSpeciality, String varCity, String varReqDate, String varStatus, String varAppDate, String varLatestStatus, String varStatusUpdatedBy, String varEmpCode, String varEmpName, String varReqRemarks, String varAppRemarks, String varMobileNo, String varDrReqCode) {
        this.varDrName = varDrName;
        this.varCategory = varCategory;
        this.varSpeciality = varSpeciality;
        this.varCity = varCity;
        this.varReqDate = varReqDate;
        this.varStatus = varStatus;
        this.varAppDate = varAppDate;
        this.varLatestStatus = varLatestStatus;
        this.varStatusUpdatedBy = varStatusUpdatedBy;
        this.varEmpCode = varEmpCode;
        this.varEmpName = varEmpName;
        this.varReqRemarks = varReqRemarks;
        this.varAppRemarks = varAppRemarks;
        this.varMobileNo = varMobileNo;
        this.varDrReqCode = varDrReqCode;
    }

    public String getVarDrName() {
        return varDrName;
    }

    public void setVarDrName(String varDrName) {
        this.varDrName = varDrName;
    }

    public String getVarCategory() {
        return varCategory;
    }

    public void setVarCategory(String varCategory) {
        this.varCategory = varCategory;
    }

    public String getVarSpeciality() {
        return varSpeciality;
    }

    public void setVarSpeciality(String varSpeciality) {
        this.varSpeciality = varSpeciality;
    }

    public String getVarCity() {
        return varCity;
    }

    public void setVarCity(String varCity) {
        this.varCity = varCity;
    }

    public String getVarReqDate() {
        return varReqDate;
    }

    public void setVarReqDate(String varReqDate) {
        this.varReqDate = varReqDate;
    }

    public String getVarStatus() {
        return varStatus;
    }

    public void setVarStatus(String varStatus) {
        this.varStatus = varStatus;
    }

    public String getVarAppDate() {
        return varAppDate;
    }

    public void setVarAppDate(String varAppDate) {
        this.varAppDate = varAppDate;
    }

    public String getVarLatestStatus() {
        return varLatestStatus;
    }

    public void setVarLatestStatus(String varLatestStatus) {
        this.varLatestStatus = varLatestStatus;
    }

    public String getVarStatusUpdatedBy() {
        return varStatusUpdatedBy;
    }

    public void setVarStatusUpdatedBy(String varStatusUpdatedBy) {
        this.varStatusUpdatedBy = varStatusUpdatedBy;
    }

    public String getVarEmpCode() {
        return varEmpCode;
    }

    public void setVarEmpCode(String varEmpCode) {
        this.varEmpCode = varEmpCode;
    }

    public String getVarEmpName() {
        return varEmpName;
    }

    public void setVarEmpName(String varEmpName) {
        this.varEmpName = varEmpName;
    }

    public String getVarReqRemarks() {
        return varReqRemarks;
    }

    public void setVarReqRemarks(String varReqRemarks) {
        this.varReqRemarks = varReqRemarks;
    }

    public String getVarAppRemarks() {
        return varAppRemarks;
    }

    public void setVarAppRemarks(String varAppRemarks) {
        this.varAppRemarks = varAppRemarks;
    }

    public String getVarMobileNo() {
        return varMobileNo;
    }

    public void setVarMobileNo(String varMobileNo) {
        this.varMobileNo = varMobileNo;
    }

    public String getVarDrReqCode() {
        return varDrReqCode;
    }

    public void setVarDrReqCode(String varDrReqCode) {
        this.varDrReqCode = varDrReqCode;
    }

}
