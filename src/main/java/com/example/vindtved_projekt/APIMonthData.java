package com.example.vindtved_projekt;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class APIMonthData {
    @SerializedName("date")
    public String date;

    @SerializedName("daily_wind_total")
    public double daily_wind_total;

    @SerializedName("daily_solar_total")
    public double daily_solar_total;

    @SerializedName("daily_total")
    public double daily_total;
}
