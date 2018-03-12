package com.retrofit.prac.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.android.databinding.library.baseAdapters.BR;
import com.retrofit.prac.R;


import com.retrofit.prac.databinding.RowDriverScheduleBinding;
import com.retrofit.prac.databinding.ViewChildListBinding;
import com.retrofit.prac.model.DriverSchedule;

import java.util.List;

/**
 * Created by User1 on 09-03-2018.
 */

public class DriverScheduleAdapter extends RecyclerView.Adapter<DriverScheduleAdapter.DriverScheduleHolder> {

    Context mContext;
    List<DriverSchedule.Schedules> driverSchedule;
    RowDriverScheduleBinding binding;

    public DriverScheduleAdapter(Context mContext, List<DriverSchedule.Schedules> driverSchedule) {
        super();
        this.driverSchedule = driverSchedule;
        this.mContext = mContext;
    }

    @Override
    public DriverScheduleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_driver_schedule, parent, false);
        return new DriverScheduleHolder(binding);
    }

    @Override
    public void onBindViewHolder(DriverScheduleHolder holder, int position) {
        holder.bindConnection(driverSchedule.get(position));

    }

    @Override
    public int getItemCount() {
        return driverSchedule.size();
    }


    public class DriverScheduleHolder extends RecyclerView.ViewHolder {
        RowDriverScheduleBinding binding;
        public DriverScheduleHolder(RowDriverScheduleBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        public void bindConnection(DriverSchedule.Schedules obj) {
            // binding.setVariable(BR._all, obj);

            binding.setVariable(BR.routedetails, obj.getRoute_details());
            LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            buttonLayoutParams.setMargins(0, 0, 8, 0);
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            for (int i=0;i<obj.getAlloted_kids().size();i++) {
                View view = layoutInflater.inflate(R.layout.view_child_list, null);
                ViewChildListBinding binding1=DataBindingUtil.bind(view);
                view.setLayoutParams(buttonLayoutParams);
                binding.idGallery.addView(view);
                binding1.setVariable(BR.alloted_kids, obj.getAlloted_kids().get(i));


            }
            binding.executePendingBindings();
        }
    }
}
