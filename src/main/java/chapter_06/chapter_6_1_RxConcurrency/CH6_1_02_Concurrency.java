package chapter_06.chapter_6_1_RxConcurrency;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;

public class CH6_1_02_Concurrency {

    public static void main(String[] args) {

        Observable.just("Alpha", "Beta", "Gamma", "Delta")
                .subscribeOn(Schedulers.computation())
                .map(CH6_1_02_Concurrency::longRunningFunction)
                .subscribe(i -> System.out.println("observer 1: " + i + "   [on thread " + Thread.currentThread().getName() + "]"));

        Observable.just(1, 2, 3, 4)
                .subscribeOn(Schedulers.computation())
                .map(CH6_1_02_Concurrency::longRunningFunction)
                .subscribe(i -> System.out.println("observer 2: " + i + "   [on thread " + Thread.currentThread().getName() + "]"));

        sleep(10_000);
    }

    private static <T> T longRunningFunction(T value) {
        sleep(ThreadLocalRandom.current().nextInt(3000));
        return value;
    }

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
