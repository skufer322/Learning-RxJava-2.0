package chapter_7.chapter_7_1_Buffering;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CH7_1_04_Buffering_TimeBased {

    public static void main(String[] args) {
        Observable.interval(1, TimeUnit.SECONDS)
                .buffer(2, TimeUnit.SECONDS)
                .subscribe(l -> System.out.println("Received: " + l));

        sleep(10_000);
    }

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
