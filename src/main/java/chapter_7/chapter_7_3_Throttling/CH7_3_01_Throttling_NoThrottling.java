package chapter_7.chapter_7_3_Throttling;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CH7_3_01_Throttling_NoThrottling {

    public static void main(String[] args) {
        Observable<String> observable1 = Observable.interval(100, TimeUnit.MILLISECONDS)
                .take(10)
                .map(l -> "SOURCE 1: " + ((l + 1) * 100));

        Observable<String> observable2 = Observable.interval(300, TimeUnit.MILLISECONDS)
                .take(3)
                .map(l -> "SOURCE 2: " + ((l + 1) * 300));

        Observable<String> observable3 = Observable.interval(2, TimeUnit.SECONDS)
                .take(2)
                .map(l -> "SOURCE 3: " + ((l + 1) * 2_000));

        Observable.concat(observable1, observable2, observable3)
                .subscribe(System.out::println);

        sleep(6_000);
    }

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
