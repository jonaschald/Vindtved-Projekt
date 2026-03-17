package com.example.vindtved_projekt;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class APILatestReading
{
    @SerializedName("solar_effect")
    private String solarEffect;

    @SerializedName("solar_gradiation")
    private String solarGradiation;

    @SerializedName("wind_effect")
    public int windEffect;

    @SerializedName("wind_speed")
    public double windSpeed;

    @SerializedName("logged_at")
    public Date loggedAt;

    @SerializedName("data")
    public APIData data;
}
