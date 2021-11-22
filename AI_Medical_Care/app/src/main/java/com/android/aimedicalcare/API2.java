package com.android.aimedicalcare;


import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API2 {

    @POST("complaintText")
    Call<MyResponse> postComplaint(@Body MyPostData postData);

    @GET("test")
    Call<ResponseBody> test();




}
