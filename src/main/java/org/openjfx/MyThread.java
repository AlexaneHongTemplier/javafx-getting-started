package org.openjfx;

public class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println("This is my parallel operation");
    }

}
