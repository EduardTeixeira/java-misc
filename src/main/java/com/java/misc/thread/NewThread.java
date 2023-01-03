package com.java.misc.thread;

public class NewThread extends Thread {

    public void run() {

        long startTime = System.currentTimeMillis();

        int i = 0;

        boolean continueThread = true;

        while (continueThread) {

            System.out.println(this.getName() + ": New Thread is running..." + i++);

            try {

                //Wait for one sec so it doesn't print too fast
                Thread.sleep(1000);
                System.out.println("thread sleep.");

                if(i == 5){
                    continueThread = false;
                    try {
                        throw new Exception("ERRO NA THREAD...");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }

}
