package org.openjfx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MyChart extends VBox {
    private  XYChart.Series<Double, Double> series = new XYChart.Series<>();
    public MyChart() {
        Button myB = new Button("Button");
        final int[] x = {0};
        LineChart lc = new LineChart(
                new NumberAxis("Time Constant", 0.0, 10.0, 30),
                new NumberAxis("Voltage (Vs)", 0.0, 1.0, 0.1));
        myB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Button is working");
                for (int i=0; i<10;i++) {
                    //series.getData().add(new XYChart.Data<>(Double.valueOf(i), Math.random()));
                    buildSampleLineChart(i);
                }
            }
        });
        lc.getData().add(series);
        getChildren().add(myB);
        getChildren().add(lc);
    }

    public void buildSampleLineChart(int x) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Runnable updater = new Runnable() {
                    @Override
                    public void run() {
                            series.getData().add(new XYChart.Data<>(Double.valueOf(x), Math.random()));
                            if (series.getData().size() > 10) {
                                series.getData().remove(0);
                                //xAxis.setLowerBound(series.getData().get(0).getXValue());
                                //xAxis.setUpperBound(series.getData().get(series.getData()).getXValue());
                            }

                    }
                };
                while(true){
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException ex){}
                    Platform.runLater(updater);
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }
}