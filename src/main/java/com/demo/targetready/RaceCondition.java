package com.demo.targetready;

public class RaceCondition {

    public static void main(String[] args){
        Visitor visitor = new Visitor();
        for(int i = 0; i < 10; i++){
            Thread t = new Thread(new Counter(visitor));
            t.start();
        }

    }
}

class Visitor{
    Integer visitorCount = 0;

    public void incrementCounter(){
        try{
            Thread.sleep(100);
        } catch(InterruptedException e){
            e.printStackTrace();
        }

        synchronized (visitorCount){
            visitorCount++;
        }

    }

    public int getVisitorCount(){
        return visitorCount;
    }
}