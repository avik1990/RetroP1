package com.retrofit.prac;

import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.retrofit.prac.adapter.DriverScheduleAdapter;
import com.retrofit.prac.databinding.ActivityMainBinding;
import com.retrofit.prac.model.DriverSchedule;
import com.retrofit.prac.retrofit.api.ApiServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    Context mContext;
    ProgressDialog pDialog;
    private static final String BASE_URL = "http://api.dev.kidpool.in/1.1/api/Driver/driver_schedule/driver_id/1/device_id/861645036247906/user_type/D/device_token/eMx488eNIys:APA91bFdMejUTCa6FENzdulH42KUjF_nibfgjOAccA-8yT2KY4uJuPx7EdfJPbIgNatrfn0y5CzSOKxKgSi_hpA6yyqQpUpBi_u-MuIXON3nLAhNvlT-vzNABCZpzIYzK7JOwKx5uXr_/mobile/9000000001/device_type/A/";
    private static final String TAG = "MainActivity";
    DriverSchedule list_driver;
    DriverScheduleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        initiew();
        parsejsondata();
    }

    private void initiew() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        pDialog = new ProgressDialog(mContext);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.setCanceledOnTouchOutside(false);
    }

    private void parsejsondata() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiServices redditAPI;
        redditAPI = retrofit.create(ApiServices.class);
        Call<DriverSchedule> call = redditAPI.getDriverSchedule();
        call.enqueue(new Callback<DriverSchedule>() {

            @Override
            public void onResponse(Call<DriverSchedule> call, Response<DriverSchedule> response) {
                Log.d(TAG, "onResponse: Server Response: " + response.toString());
                Log.d(TAG, "onResponse: received information: " + response.body().toString());
                list_driver = response.body();
                //Toast.makeText(mContext, "" + medi_data.size(), Toast.LENGTH_SHORT).show();
                //Log.d(TAG, "Size: " + medi_data.size());
                //AppDatabase.getAppDatabase(MainActivity.this).mediDao().insertAll(medi_data);
                if (response.isSuccessful()) {
                    if (list_driver.getStatus().equals("1")) {
                        Toast.makeText(mContext, "" + list_driver.getData().getSclist().size(), Toast.LENGTH_SHORT).show();
                    }
                }
               inflateadapter();
            }

            @Override
            public void onFailure(Call<DriverSchedule> call, Throwable t) {
                Toast.makeText(mContext, "Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void inflateadapter() {
        adapter = new DriverScheduleAdapter(mContext, list_driver.getData().getSclist());
        binding.rvRecycle.setLayoutManager(new LinearLayoutManager(this));
        binding.rvRecycle.setAdapter(adapter);
    }
}
