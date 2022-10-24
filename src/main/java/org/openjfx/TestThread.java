package org.openjfx;

import javafx.scene.chart.XYChart;

public class TestThread {
    public static void main (String [] args){
        Thread t=new Thread(){
            public void run() {
                System.out.println("This is my parallel operation");
            }
        };
        t.start();
    }

}
