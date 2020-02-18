package chapter_2;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class CH2_09_Observable_Interval_HotObservable {

    public static void main(String[] args) {
        ConnectableObservable<Long> connectableObservable = Observable.interval(1, TimeUnit.SECONDS).publish();

        connectableObservable.subscribe(val -> System.out.println("obs_1: " + val));
        connectableObservable.connect();

        sleep(3);
        connectableObservable.subscribe(val -> System.out.println("obs_2: " + val));
        sleep(3);
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
