package chapter_6.chapter_6_5_Parallelization;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class CH6_5_03_Parallelization_GroupBy {

    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        AtomicInteger assigner = new AtomicInteger();

        Observable.range(1, 16)
                .groupBy(i -> assigner.getAndIncrement() % coreCount)
                .flatMap(grp ->
                        grp.observeOn(Schedulers.computation())
                                .map(i -> longRunningMethod(i))
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
