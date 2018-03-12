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
    public String status;

    @SerializedName("msg")
    @Expose
    public String msg;

    @SerializedName("data")
    @Expose
    public Data data;

    public class Data {
        @Getter
        @SerializedName("schedules")
        @Expose
        List<Schedules> sclist;
        @Getter
        @SerializedName("driver_details")
        @Expose
        Driver_details driver_details;
    }

    public class Schedules {
        @Getter
        @SerializedName("is_active")
        @Expose
        public String is_active;

        @Getter
        @SerializedName("route_details")
        @Expose
        public Route_details route_details;

        @Getter
        @SerializedName("alloted_kids")
        @Expose
        public List<Alloted_kids> alloted_kids;
    }

    public class Driver_details {
        @Getter
        @SerializedName("driver_details")
        @Expose
        public Driver_details1 driver_details;
    }

    public class Route_details {
        @SerializedName("ds_id")
        @Expose
        public String ds_id;

        @SerializedName("kidpool_route_id")
        @Expose
        public String kidpool_route_id;


        public String getDs_id() {
            return ds_id;
        }

        public void setDs_id(String ds_id) {
            this.ds_id = ds_id;
        }

        public String getKidpool_route_id() {
            return kidpool_route_id;
        }

        public void setKidpool_route_id(String kidpool_route_id) {
            this.kidpool_route_id = kidpool_route_id;
        }
    }

    public class Alloted_kids {
        @Getter
        @SerializedName("kid_name")
        @Expose
        public String kid_name;


        @SerializedName("kid_image")
        @Expose
        public String kid_image;
    }

    public class Driver_details1 {
        @Getter
        @SerializedName("driver_id")
        @Expose
        public String driver_id;

        @Getter
        @SerializedName("driver_name")
        @Expose
        public String driver_name;
    }


}
