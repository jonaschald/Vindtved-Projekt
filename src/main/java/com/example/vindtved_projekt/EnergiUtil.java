package com.example.vindtved_projekt;

public class EnergiUtil {
    private static final double HOUSEHOLD_DAILY = 11.2;
    private static final double PERSON_DAILY = 4.3;

    private static final double SOLAR_RATE = 811;
    private static final double WIND_RATE = 702;

    // Kilowatt timer til CO2 i kg
    public static double kwh2co2(double kwh, String rate) {
        double r = switch (rate.toLowerCase()) {
            case "solar" -> SOLAR_RATE;
            case "wind" -> WIND_RATE;
            default -> throw new IllegalArgumentException(String.format("Ukendt rate: %s", rate));
        };

        return kwh * r / 1000; // g => kg
    }

    // Kilowatt timer til CO2 i ton
    public static double kwh2co2ton(double kwh, String rate) {
        return kwh2co2(kwh, rate) / 1000;
    }

    public static double kwh2households(double kwh) {
        return kwh / HOUSEHOLD_DAILY;
    }

    public static double kw2households(double kw) {
        return kw * 24 / HOUSEHOLD_DAILY;
    }

    public static double kw2persons(double kw) {
        return kw * 24 / PERSON_DAILY;
    }

    /*
     taget fra javascript:

     daily_emission_of_district(data) {
         const {location}            = data;
         const daily_emissing        = location.district_yearly_emission / 365;
         const last_day_displacement = kwh2co2ton(data.avg_wind_effect_total_last_day * 24, 'wind') +
            kwh2co2ton(data.avg_solar_effect_total_last_day * 24, 'solar');
         return last_day_displacement / daily_emissing;
     };
     */

    public static double daily_emission_of_district(double yearly_emission, double avg_wind_effect, double avg_solar_effect) {
        double daily_emission           = yearly_emission / 365;
        double last_day_displacement    = kwh2co2ton(avg_wind_effect * 24, "wind") + kwh2co2ton(avg_solar_effect * 24, "solar");

        return last_day_displacement / daily_emission;
    }

    /*
     taget fra javascript:

     daily_production_of_district(data) {
         const {location}          = data;
         const daily_consumption   = location.district_consumption / 365;
         const last_day_production = data.avg_total_last_day * 24;
         return last_day_production / daily_consumption;
     };
     */

    public static double daily_production_of_district(double district_consumption, double avg_total) {
        double daily_consumption    = district_consumption / 365;
        double last_day_production  = avg_total * 24;

        return last_day_production / daily_consumption;
    }
}
