package chapter_05.chapter_5_2_AutoConnect;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CH5_2_03_AutoConnect_0 {
    public static void main(String[] args) {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS)
                .publish()
                .autoConnect(0);

        sleep(2);

        observable.subscribe(i -> System.out.println("Observer 1: " + i));

        sleep(5);
    }

    private static void sleep(int seconds){
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
