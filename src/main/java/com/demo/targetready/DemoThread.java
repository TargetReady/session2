package com.demo.targetready;

public class DemoThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Running Thread " + Thread.currentThread().getName() + ". count is " + i);
        }

    }
}