package chapter_1;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableTryOut_3_Interval {

    public static void main(String[] args){
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(val -> System.out.println("time passed: " + val + " (seconds)"));

        try {
            Thread.sleep(5500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
