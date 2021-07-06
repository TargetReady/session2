package com.demo.targetready;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        MyThread t1=new MyThread();
        t1.start();


        MyRunnable m1=new MyRunnable();
        Thread t2 =new Thread(m1);
        t2.start();


        // calling run instead of start
        DemoThread t3=new DemoThread();
        DemoThread t4=new DemoThread();
        t3.run(); t3.setName("t3");
        t4.run(); t4.setName("t4");//no context-switching because here t1 and t2 will be treated as normal object

        DemoThread t5=new DemoThread();
        DemoThread t6=new DemoThread();
        DemoThread t7=new DemoThread();
        DemoThread t8=new DemoThread();

        t5.setName("t5"); t5.start();
        t5.setName("t5"); t6.start();

        try{
            t6.join();
        }
        catch(Exception e){
            System.out.println(e);
        }
        t7.setName("t7"); t7.start();
        t8.setName("t8"); t8.start();

        //Creating threads in thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for(int i = 0 ; i < 10; i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("Executing thread "+Thread.currentThread().getName());
                }
            };

            executorService.execute(runnable);
        }

        executorService.shutdown();
    }
}

