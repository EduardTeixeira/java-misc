package com.java.misc.thread;

public class MultipleThreadsExample {

    public static String testeErro(Integer entrada) throws Exception {
        try {
            if (entrada == 0) {
                return "Sucesso !!!";
            } else {
                throw new Exception("Erro na thread...");
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static void main(String[] args) {

        try {

            Thread thread1 = new Thread(() -> {
                try {
                    System.out.println(testeErro(0));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            thread1.start();
            thread1.join();

            Thread thread2 = new Thread(() -> {
                try {
                    System.out.println(testeErro(1));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            thread2.start();
            thread2.join();
            System.out.println(thread2.getState());
            StackTraceElement[] a1 = thread2.getStackTrace();
            System.out.println(a1.length);

            NewThread t1 = new NewThread();
            t1.setName("MyThread-1");

            NewThread t2 = new NewThread();
            t2.setName("MyThread-2");

            System.out.println(t1.getState());
            t1.start();
            System.out.println(t1.getState());
            t1.join();
            System.out.println(t1.getState());
            StackTraceElement[] a = t1.getStackTrace();
            System.out.println(a.length);

            t2.start();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
