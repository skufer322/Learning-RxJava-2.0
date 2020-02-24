package chapter_6.chapter_6_5_Parallelization;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

public class CH6_5_02_Parallelization_Parallelization {

    public static void main(String[] args) {
        Observable.range(1, 16)
                .flatMap(i ->
                        Observable.just(i)
                                .subscribeOn(Schedulers.computation())
                                .map(i2 -> longRunningMethod(i2))
                )
                .subscribe(i -> System.out.println("Received " + i + " at " + LocalTime.now() + " on thread " + Thread.currentThread().getName()));

        sleep(10_000);
    }

    private static <T> T longRunningMethod(T value) {
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
