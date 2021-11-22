package com.android.aimedicalcare;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MyPostData implements Serializable {
    @SerializedName("text")
    private String text;

    @SerializedName("name")
    private String name;


    public MyPostData(String name, String text ){
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
}
