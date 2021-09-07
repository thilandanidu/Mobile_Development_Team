package com.example.retrofitandroidsessionone;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResponse {

    @SerializedName("cnt")
    int cnt;

    @SerializedName("list")
    List<WeatherDataModel> listData;
}
