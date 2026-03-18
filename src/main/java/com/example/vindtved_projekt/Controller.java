package com.example.vindtved_projekt;

import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.GaugeBuilder;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Controller
{
    // Gauge til hver enkelt mølle
    Gauge m1Gauge;
    Gauge m2Gauge;
    Gauge m3Gauge;
    Gauge m4Gauge;
    Gauge m5Gauge;
    Gauge m6Gauge;

    // Vind hastinghed m/s
    Gauge vindmsGauge;

    // Samlet effekt af alle møller
    Gauge effektSamletGauge;

    // Måneds Oversigt
    CategoryAxis xAxisM = new CategoryAxis();
    NumberAxis yAxisM = new NumberAxis();
    LineChart<String, Number> lineChartMonth = new LineChart<>(xAxisM, yAxisM);
    XYChart.Series<String, Number> seriesM = new XYChart.Series<>();

    private Timeline venteTimer;

    public void initialize()
    {
        setUpGauges();
        setUpLineChart();
    }

    // Metode der henter vindmølle data hvert 10. minut og gemmer det i vores database
    private void hentDataHvert10Minut()
    {
        venteTimer = new Timeline(
                new KeyFrame(Duration.minutes(10), e ->
                {

                })
        );
        venteTimer.setCycleCount(Timeline.INDEFINITE);
        venteTimer.play();
    }

    public void setUpGauges() {
        m1Gauge = GaugeBuilder.create()
                .skinType(Gauge.SkinType.FLAT)
                .title("M1 Effect")
                .unit("kW")
                .maxValue(5000)
                .animated(true)
                .foregroundBaseColor(Color.rgb(0, 180, 0))
                .barColor(Color.rgb(0, 180, 0))
                .build();

        m2Gauge = GaugeBuilder.create()
                .skinType(Gauge.SkinType.FLAT)
                .title("M2 Effect")
                .unit("kW")
                .maxValue(5000)
                .animated(true)
                .foregroundBaseColor(Color.rgb(0, 180, 0))
                .barColor(Color.rgb(0, 180, 0))
                .build();

        m3Gauge = GaugeBuilder.create()
                .skinType(Gauge.SkinType.FLAT)
                .title("M3 Effect")
                .unit("kW")
                .maxValue(5000)
                .animated(true)
                .foregroundBaseColor(Color.rgb(0, 180, 0))
                .barColor(Color.rgb(0, 180, 0))
                .build();

        m4Gauge = GaugeBuilder.create()
                .skinType(Gauge.SkinType.FLAT)
                .title("M4 Effect")
                .unit("kW")
                .maxValue(5000)
                .animated(true)
                .foregroundBaseColor(Color.rgb(0, 180, 0))
                .barColor(Color.rgb(0, 180, 0))
                .build();

        m5Gauge = GaugeBuilder.create()
                .skinType(Gauge.SkinType.FLAT)
                .title("M5 Effect")
                .unit("kW")
                .maxValue(5000)
                .animated(true)
                .foregroundBaseColor(Color.rgb(0, 180, 0))
                .barColor(Color.rgb(0, 180, 0))
                .build();

        m6Gauge = GaugeBuilder.create()
                .skinType(Gauge.SkinType.FLAT)
                .title("M6 Effect")
                .unit("kW")
                .maxValue(5000)
                .animated(true)
                .foregroundBaseColor(Color.rgb(0, 180, 0))
                .barColor(Color.rgb(0, 180, 0))
                .build();

        vindmsGauge = GaugeBuilder.create()
                .skinType(Gauge.SkinType.SIMPLE_DIGITAL)
                .foregroundBaseColor(Color.rgb(0, 120, 255))
                .barColor(Color.rgb(0, 120, 255))
                .unit("m/s")
                .maxValue(30)
                .animated(true)
                .build();

        effektSamletGauge = GaugeBuilder.create()
                .skinType(Gauge.SkinType.MODERN)
                .title("Samlet Effekt")
                .unit("kW")
                .minorTickSpace(100)
                .minValue(-5000)
                .maxValue(5000)
                .value(0)
                .animated(true)
                .build();

        // Alle skal sættet på fxml
    }

    private void setUpLineChart(){
        lineChartMonth.setAnimated(false);
        lineChartMonth.setTitle("Måneds Oversigt over samlet effekt");
        yAxisM.setLabel("Samlet effekt");
        xAxisM.setLabel("Dato");
        seriesM.setName("Samlet effekt");
        // Skal sættet på fxml
    }
}
