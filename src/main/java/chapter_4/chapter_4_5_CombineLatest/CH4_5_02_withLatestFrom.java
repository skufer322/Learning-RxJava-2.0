package chapter_4.chapter_4_5_CombineLatest;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CH4_5_02_withLatestFrom {

    public static void main(String[] args) {
        Observable<String> observable1 = Observable.interval(1, TimeUnit.SECONDS)
                .map(i -> (i + 1) + " seconds");
        Observable<String> observable2 = Observable.interval(600, TimeUnit.MILLISECONDS)
                .map(i -> ((i + 1) * 600) + " milliseconds passed");

        observable1.withLatestFrom(observable2, (s1, s2) -> s1 + " - " + s2)
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
