package com.retrofit.prac.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.retrofit.prac.model.DriverSchedule;

/**
 * Created by User1 on 09-03-2018.
 */

public class DriverScheduleAdapter extends RecyclerView.Adapter<DriverScheduleAdapter.DriverScheduleHolder> {

    Context mContext;
    DriverSchedule driverSchedule;

    public DriverScheduleAdapter(Context mContext, DriverSchedule driverSchedule) {
        super();
        this.driverSchedule=driverSchedule;
        this.mContext=mContext;
    }

    @Override
    public DriverScheduleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(DriverScheduleHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class DriverScheduleHolder extends RecyclerView.ViewHolder {
        public DriverScheduleHolder(View itemView) {
            super(itemView);
        }
    }
}
