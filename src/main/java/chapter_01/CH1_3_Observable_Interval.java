package chapter_01;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CH1_3_Observable_Interval {

    public static void main(String[] args) {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(val -> System.out.println("time passed: " + val + " (seconds)"));

        try {
            Thread.sleep(5500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
