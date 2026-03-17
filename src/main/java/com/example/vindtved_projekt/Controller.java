package com.example.vindtved_projekt;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Controller
{
    private Timeline venteTimer;

    public void initialize()
    {

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
}
