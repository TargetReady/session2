package com.demo.targetready;

public class Counter implements Runnable {
    Visitor visitor = new Visitor();

    Counter(Visitor visitor){
        this.visitor = visitor;
    }
    @Override
    public void run() {
        visitor.incrementCounter();
        System.out.println("Visitor count for thread "+Thread.currentThread().getName()+" is "+visitor.getVisitorCount());
    }
}
