package chapter_2;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CH2_08_Observable_Interval {

    public static void main(String[] args) {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);

        observable.subscribe(val -> System.out.println("obs_1: " + val));

        sleep(5);
        observable.subscribe(val -> System.out.println("obs_2: " + val));
        sleep(10);
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
