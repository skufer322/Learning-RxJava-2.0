package chapter_08.chapter_8_4_BackpressureXXX_Operators;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class CH8_4_01_Flowable_BackpressureBuffer {

    public static void main(String[] args) {
        Flowable.interval(1, TimeUnit.MILLISECONDS)
                .onBackpressureBuffer(5, () -> System.out.println("Overflow"), BackpressureOverflowStrategy.DROP_LATEST)
                .observeOn(Schedulers.io())
                .subscribe(l -> {
                    sleep(5);
                    System.out.println("Received " + l);
                });

        sleep(1_000);
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
