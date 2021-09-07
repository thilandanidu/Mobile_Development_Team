package com.example.retrofitandroidsessionone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;

    Button button1 ;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.btn1);
        progressBar = findViewById(R.id.progress_circular);

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);

                apiInterface = ApiClient.getClient().create(ApiInterface.class);

                Call<WeatherResponse> call = apiInterface.getWeatherResponse("1248991,1241622,1275339,524901,703448,2643743", "metric", "60793f8c34e42fd440f886dbb2baccc9");

                call.enqueue(new Callback<WeatherResponse>() {
                    @Override
                    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                        progressBar.setVisibility(View.GONE);
                        if( response.isSuccessful()){
                            Log.d("-------------", response.body().listData +"");
                        }
                        else {
                            Log.d("-------------", response.message() +"");
                        }
                    }

                    @Override
                    public void onFailure(Call<WeatherResponse> call, Throwable t) {
                        progressBar.setVisibility(View.GONE);
                        Log.d("-------------", "fail" + t.getMessage());
                    }
                });
            }
        });
    }
}