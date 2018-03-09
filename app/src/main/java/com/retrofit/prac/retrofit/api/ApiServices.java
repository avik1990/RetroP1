package com.retrofit.prac.retrofit.api;

import com.retrofit.prac.model.DriverSchedule;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by User1 on 09-03-2018.
 */

public interface ApiServices {
    @GET(".")
    Call<DriverSchedule> getDriverSchedule();


}
