package com.retrofit.prac.model;

import android.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;
import lombok.Getter;

/**
 * Created by User1 on 09-03-2018.
 */

@Data
public class DriverSchedule extends BaseObservable {

    @SerializedName("status")
    @Expose
    String status;

    @SerializedName("msg")
    @Expose
    String msg;

    @SerializedName("data")
    @Expose
    Data data;

    public class Data {
        @Getter
        @SerializedName("schedules")
        @Expose
        List<Schedules> schedules;
        @Getter
        @SerializedName("driver_details")
        @Expose
        Driver_details driver_details;
    }

    public class Schedules {
        @SerializedName("is_active")
        @Expose
        String is_active;

        @SerializedName("route_details")
        @Expose
        Route_details route_details;

        @SerializedName("alloted_kids")
        @Expose
        List<Alloted_kids> alloted_kids;
    }

    public class Driver_details {
        @SerializedName("driver_details")
        @Expose
        Driver_details1 driver_details;
    }

    public class Route_details {
        @SerializedName("ds_id")
        @Expose
        String ds_id;

        @SerializedName("kidpool_route_id")
        @Expose
        String kidpool_route_id;
    }

    public class Alloted_kids {
        @SerializedName("kid_name")
        @Expose
        String kid_name;
    }

    public class Driver_details1 {
        @SerializedName("driver_id")
        @Expose
        String driver_id;

        @SerializedName("driver_name")
        @Expose
        String driver_name;
    }


}
