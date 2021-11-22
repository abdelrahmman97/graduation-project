package com.android.aimedicalcare;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MyResponse implements Serializable {
    @SerializedName("Symptoms")
    private List<String>  Symptoms ;

    @SerializedName("diagnose1")
    private String diagnose1;

    @SerializedName("diagnose2")
    private String diagnose2;


    public List<String> getSymptoms() {
        return Symptoms;
    }


    public String getDiagnose1() {
        return diagnose1;
    }

    public String getDiagnose2() {
        return diagnose2;
    }
}
