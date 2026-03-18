package com.example.vindtved_projekt;

import com.google.gson.annotations.SerializedName;

public class APIMathData {
    @SerializedName("location")
    public Location location;

    @SerializedName("avg_wind_effect_total_last_day")
    public Double avgWindEffectTotalLastDay;

    @SerializedName("avg_solar_effect_total_last_day")
    public Double avgSolarEffectTotalLastDay;

    @SerializedName("avg_total_last_day")
    public Double avgTotalLastDay;

    public static class Location {
        @SerializedName("district_yearly_emission")
        public Double districtYearlyEmission;

        @SerializedName("district_consumption")
        public Double districtConsumption;
    }
}
