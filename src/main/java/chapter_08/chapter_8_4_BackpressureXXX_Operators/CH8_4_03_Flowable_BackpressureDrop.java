package chapter_08.chapter_8_4_BackpressureXXX_Operators;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class CH8_4_03_Flowable_BackpressureDrop {

    public static void main(String[] args) {
        Flowable.interval(1, TimeUnit.MILLISECONDS)
                .onBackpressureDrop(i -> System.out.println("Dropped " + i))
                .observeOn(Schedulers.io())
                .subscribe(i -> {
                            sleep(5);
                            System.out.println("Received " + i);
                        }
                );

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
