package com.java.misc.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CompletableFutureExample {

    public static CompletableFuture<String> compFuture(String title, Integer sleepSeconds) {
        return CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    System.out.println("Começo: " + title);
                    TimeUnit.SECONDS.sleep(sleepSeconds);
                    System.out.println("Fim: " + title);
                    return "Retorno..." + title;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.out.println("CompletableFutureExample...Inicio");

        CompletableFuture<String> futurePrimeiro = compFuture("Primeiro", 3);

        CompletableFuture<String> futureSegundo = compFuture("Segundo", 5);

        String segundo = futureSegundo.get();
        System.out.println(segundo);

        String primeiro = futurePrimeiro.get();
        System.out.println(primeiro);

        System.out.println("CompletableFutureExample...Fim");
    }

}
