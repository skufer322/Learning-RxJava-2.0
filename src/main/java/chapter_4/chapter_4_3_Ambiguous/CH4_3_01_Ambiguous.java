package chapter_4.chapter_4_3_Ambiguous;

import io.reactivex.Observable;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CH4_3_01_Ambiguous {

    public static void main(String[] args) {
        Observable<String> observable1 = Observable.interval(1, TimeUnit.SECONDS)
                .map(val -> "1s interval: " + (val + 1) + " seconds passed");
        Observable<String> observable2 = Observable.interval(990, TimeUnit.MILLISECONDS)
                .map(val -> "990ms interval: " + ((val + 1) * 990) + " milliseconds passed");
        Observable<String> observable3 = Observable.interval(990_999, TimeUnit.MICROSECONDS)
                .map(val -> "990_999micros interval: " + ((val + 1) * 990_999) + " microseconds passed");

        Observable.amb(List.of(observable1, observable2, observable3))
                .subscribe(System.out::println);

        sleep(5);
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
