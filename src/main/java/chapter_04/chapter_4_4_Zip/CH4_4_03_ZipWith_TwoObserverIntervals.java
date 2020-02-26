package chapter_04.chapter_4_4_Zip;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CH4_4_03_ZipWith_TwoObserverIntervals {

    public static void main(String[] args) {
        Observable<String> observable1 = Observable.interval(1, TimeUnit.SECONDS)
                .map(i -> "1s interval: " + (i + 1) + " seconds passed");
        Observable<String> observable2 = Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(i -> "300ms interval: " + ((i + 1) * 300) + " milliseconds passed");

        Observable.zip(observable1, observable2, (s1, s2) -> s1 + " - " + s2)
                .subscribe(System.out::println);

        sleep(10);
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
