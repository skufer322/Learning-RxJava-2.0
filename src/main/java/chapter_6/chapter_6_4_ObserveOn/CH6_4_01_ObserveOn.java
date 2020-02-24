package chapter_6.chapter_6_4_ObserveOn;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CH6_4_01_ObserveOn {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Observable.just("847273/WHISKEY/63/7327", "8378/FOXTROT/6215/273672/73627", "818/UNICORN/27656/11")
                .subscribeOn(Schedulers.from(executorService))
                .flatMap(s ->
                        Observable.fromArray(s.split("/"))
                                .doOnNext(s2 -> System.out.println("split " + s + " -> " + s2 + " on thread " + Thread.currentThread().getName())))
                .observeOn(Schedulers.computation())
                .filter(s -> s.matches("\\d+"))
                .doOnNext(s -> System.out.println("Mapping String to Integer: " + s + " on thread " + Thread.currentThread().getName()))
                .map(Integer::valueOf)
                .reduce(0, Integer::sum)
                .subscribe(result -> System.out.println("sum of the given integers: " + result));

        sleep(1_000);

        executorService.shutdown();
    }

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
