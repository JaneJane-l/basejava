package com.urise.webapp.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MainConcurrency {
    private static final int THREADS_NUMBER = 10000;
    private static int counter;
    private static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread thread0 = new Thread() {
            @Override
            public void run() {

                System.out.println(getName() + ", " + getState());
            }

        };
        thread0.start();
        new Thread(() ->
                System.out.println(Thread.currentThread().getName() + ", "
                + Thread.currentThread().getState())).start();
        System.out.println(thread0.getState());

        // new Thread(new Runnable() {
        //    @Override
        //  public void run() {
        //        System.out.println(Thread.currentThread().getName());
        //      }
        //  }).start();

        final MainConcurrency mainConcurrency = new MainConcurrency();
      //  List threads = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(THREADS_NUMBER);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < THREADS_NUMBER; i++) {
            Future<Integer> future = executorService.submit(()->{


            for (int j = 0; j < 100; j++) {
                    mainConcurrency.inc();
                }
                latch.countDown();
                return 5;
                        });

//            Thread thread = new Thread(() -> {
//                for (int j = 0; j < 100; j++) {
//                    mainConcurrency.inc();
//                }
//                latch.countDown();
//            });
//            thread.start();
           // threads.add(thread);

        }
     //   threads.forEach(t -> {
     //       try {
     //           t.join();
    //        } catch (InterruptedException e) {
    //            e.printStackTrace();
    //        }
    //    });



        //Thread.sleep(500);
        latch.await(10, TimeUnit.SECONDS);
        executorService.shutdown();
        System.out.println(counter);
        LazySingleton.getInstance();

        final String lock1 = "lock1";
        final String lock2 = "lock2";

//        deadLock (lock1, lock2);
//        deadLock (lock2, lock1);


    }

//  private static void deadLock(Object lock1, Object lock2){
//        new Thread(() ->{
//            System.out.println("Waiting " + lock1);
//            synchronized (lock1){
//                System.out.println("Holding " + lock1);
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("Waiting " + lock2);
//                synchronized (lock2){
//                    System.out.println("Holding " + lock2);
//                }
//            }
//
//        }).start();
//
//    }



    private synchronized void inc() {
        //synchronized (this){
        //  synchronized (MainConcurrency.class){

       // double a = Math.sin(13.);

            //synchronized (this) {
            counter++;
            //}
               // wait();
       // }
    }




}
