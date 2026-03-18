package com.example.vindtved_projekt;

import javafx.application.Application;

public class Main {
    public static void main(String[] args) {
        API api = new API();
        APILatestReading reading = api.getLatestReading();

        System.out.println(reading.solarEffect);
        System.out.println(reading.windEffect);
        System.out.println(reading.solarGradiation);
        System.out.println(reading.windSpeed);

        APIMathData apiMathData = api.getMathData();

        Double yearly_emission = apiMathData.location.districtYearlyEmission;
        Double wind_effect = apiMathData.avgWindEffectTotalLastDay;
        Double solar_effect = apiMathData.avgSolarEffectTotalLastDay;

        if (yearly_emission == null)
            yearly_emission = 0.0;

        if (wind_effect == null)
            wind_effect = 0.0;

        if (solar_effect == null)
            solar_effect = 0.0;

        System.out.println(EnergiUtil.daily_emission_of_district(yearly_emission, wind_effect, solar_effect));

        Double consumption = apiMathData.location.districtConsumption;
        Double avg_total = apiMathData.avgTotalLastDay;

        if (consumption == null)
            consumption = 0.0;

        if (avg_total == null)
            avg_total = 0.0;

        System.out.println(EnergiUtil.daily_production_of_district(consumption, avg_total));

        //Application.launch(args);
    }
}
