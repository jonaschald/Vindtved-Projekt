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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Controller
{
    @FXML
    private VBox infoVBox;
    @FXML
    private GridPane infoGridPane;

    @FXML
    private VBox effektMølleVBox;
    @FXML
    private GridPane effektMølleGridPane;

    @FXML
    private VBox samletEffektVBox;
    @FXML
    private GridPane samletEffektMølleGridPane;
    @FXML
    private GridPane samletEffektGridPane;

    @FXML
    private VBox vindhastighedVBox;
    @FXML
    private GridPane vindhastighedGridPane;

    @FXML
    private VBox manedsOversigVBox;
    @FXML
    private GridPane manedsOversigGridPane;

    // Gauge til hver enkelt mølle
    Gauge m1Gauge;
    Gauge m2Gauge;
    Gauge m3Gauge;
    Gauge m4Gauge;
    Gauge m5Gauge;
    Gauge m6Gauge;

    // Gauge til hver enkelt mølle det vises over samlet effekt
    Gauge m1sGauge;
    Gauge m2sGauge;
    Gauge m3sGauge;
    Gauge m4sGauge;
    Gauge m5sGauge;
    Gauge m6sGauge;

    // Vind hastighed m/s
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

        // Programmet starter på info skærmen
        infoVBox.setVisible(true);
        effektMølleVBox.setVisible(false);
        samletEffektVBox.setVisible(false);
        vindhastighedVBox.setVisible(false);
        manedsOversigVBox.setVisible(false);
    }

    // Knap viser info, også her programmes starter
    @FXML
    void infoKnap(ActionEvent event)
    {
        infoVBox.setVisible(true);
        effektMølleVBox.setVisible(false);
        samletEffektVBox.setVisible(false);
        vindhastighedVBox.setVisible(false);
        manedsOversigVBox.setVisible(false);
    }

    // Knap viser effekten pr. mølle
    @FXML
    void effektMølleKnap(ActionEvent event)
    {
        infoVBox.setVisible(false);
        effektMølleVBox.setVisible(true);
        samletEffektVBox.setVisible(false);
        vindhastighedVBox.setVisible(false);
        manedsOversigVBox.setVisible(false);
    }

    // Knap viser alle møllerne og den samlede effekt af alle møllerne
    @FXML
    void samletEffektKnap(ActionEvent event)
    {
        infoVBox.setVisible(false);
        effektMølleVBox.setVisible(false);
        samletEffektVBox.setVisible(true);
        vindhastighedVBox.setVisible(false);
        manedsOversigVBox.setVisible(false);
    }

    // Knap viser vindhastigheden
    @FXML
    void vindhastighedKnap(ActionEvent event)
    {
        infoVBox.setVisible(false);
        effektMølleVBox.setVisible(false);
        samletEffektVBox.setVisible(false);
        vindhastighedVBox.setVisible(true);
        manedsOversigVBox.setVisible(false);
    }

    // Knap viser måneds oversigten
    @FXML
    void manedsOverdigtKnap(ActionEvent event)
    {
        infoVBox.setVisible(false);
        effektMølleVBox.setVisible(false);
        samletEffektVBox.setVisible(false);
        vindhastighedVBox.setVisible(false);
        manedsOversigVBox.setVisible(true);
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

    // Metode til at sætte Gauges op til møllernes effekt og vindhastighed
    public void setUpGauges()
    {
        // Mølle 1, til pr. mølle
        m1Gauge = getGauge("Mølle 1 effekt");
        // Mølle 2, til pr. mølle
        m2Gauge = getGauge("Mølle 2 effekt");
        // Mølle 3, til pr. mølle
        m3Gauge = getGauge("Mølle 3 effekt");
        // Mølle 4, til pr. mølle
        m4Gauge = getGauge("Mølle 4 effekt");
        // Mølle 5, til pr. mølle
        m5Gauge = getGauge("Mølle 5 effekt");
        // Mølle 6, til pr. mølle
        m6Gauge = getGauge("Mølle 6 effekt");

        // Mølle 1, til samlet effekt
        m1sGauge = getGauge("Mølle 1 effekt");
        // Mølle 2, til samlet effekt
        m2sGauge = getGauge("Mølle 2 effekt");
        // Mølle 3, til samlet effekt
        m3sGauge = getGauge("Mølle 3 effekt");
        // Mølle 4, til samlet effekt
        m4sGauge = getGauge("Mølle 4 effekt");
        // Mølle 5, til samlet effekt
        m5sGauge = getGauge("Mølle 5 effekt");
        // Mølle 6, til samlet effekt
        m6sGauge = getGauge("Mølle 6 effekt");

        // Vindhastigheden
        vindmsGauge = GaugeBuilder.create()
                .skinType(Gauge.SkinType.SIMPLE_DIGITAL)
                .foregroundBaseColor(Color.rgb(0, 120, 255))
                .barColor(Color.rgb(0, 120, 255))
                .unit("m/s")
                .maxValue(30)
                .animated(true)
                .build();

        // Samlet effekt af alle møllerne
        effektSamletGauge = GaugeBuilder.create()
                .skinType(Gauge.SkinType.MODERN)
                .title("Samlet Effekt")
                .unit("kW")
                .minorTickSpace(2500)
                .minValue(0)
                .maxValue(25000)
                .value(0)
                .animated(true)
                .build();

        // Tilføjer møllerne til GridPane der vises når knappen Effekt pr. mølle klikkes
        effektMølleGridPane.add(m1Gauge, 0, 0);
        effektMølleGridPane.add(m2Gauge, 1, 0);
        effektMølleGridPane.add(m3Gauge, 2, 0);
        effektMølleGridPane.add(m4Gauge, 0, 1);
        effektMølleGridPane.add(m5Gauge, 1, 1);
        effektMølleGridPane.add(m6Gauge, 2, 1);

        // Tilføjer møllerne til GridPane, der viser hver mølle i en række over den samlede effekt, når knappen for samlet effekt klikkes
        samletEffektMølleGridPane.add(m1sGauge, 0, 0);
        samletEffektMølleGridPane.add(m2sGauge, 1, 0);
        samletEffektMølleGridPane.add(m3sGauge, 2, 0);
        samletEffektMølleGridPane.add(m4sGauge, 3, 0);
        samletEffektMølleGridPane.add(m5sGauge, 4, 0);
        samletEffektMølleGridPane.add(m6sGauge, 5, 0);

        // Tilføjer den samlede effekt af alle møllerne til GridPane, der vises når knappen for samlet effekt klikkes
        samletEffektGridPane.add(effektSamletGauge, 0, 0);

        // Tilføjer vindhastigheden til GridPane, der vises når knappen for vindhastighed klikkes
        vindhastighedGridPane.add(vindmsGauge, 0, 0);
    }

    // LineChart der viser oversigten over den seneste måned
    private void setUpLineChart()
    {
        lineChartMonth.setAnimated(false);
        lineChartMonth.setTitle("Måneds Oversigt over samlet effekt");
        yAxisM.setLabel("Samlet effekt");
        xAxisM.setLabel("Dato");
        seriesM.setName("Samlet effekt");

        // Tilføjer måneds oversigten til GridPane, der vises når knappen for måneds oversigt klikkes
        manedsOversigGridPane.add(lineChartMonth, 1, 0);
    }

    // Metode til at lave Gauge til mølle effekt, så man kan kalde metoden og ikke skal skrive det samme igen og igen
    private Gauge getGauge(String title)
    {
        Gauge gauge = GaugeBuilder.create()
                .skinType(Gauge.SkinType.FLAT)
                .title(title)
                .unit("kW")
                .maxValue(5000)
                .animated(true)
                .foregroundBaseColor(Color.rgb(0, 180, 0))
                .barColor(Color.rgb(0, 180, 0))
                .build();

        return gauge;
    }
}