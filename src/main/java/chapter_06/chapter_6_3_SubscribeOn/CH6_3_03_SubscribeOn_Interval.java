package chapter_06.chapter_6_3_SubscribeOn;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class CH6_3_03_SubscribeOn_Interval {

    public static void main(String[] args) {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.newThread()) // hat keine Auswirkung, da interval() standardmäßig auf computation läuft
                .take(3)
                .subscribe(s -> System.out.println("Observer 1: " + s + " - on thread " + Thread.currentThread().getName()));

        Observable.interval(1, TimeUnit.SECONDS, Schedulers.newThread())
                .take(2)
                .subscribe(s -> System.out.println("Observer 1: " + s + " - on thread " + Thread.currentThread().getName()));

        sleep(5_000);
    }

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
