package chapter_4.chapter_4_1_Merge;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CH4_1_04_Merge_InfiniteObservers {

    public static void main(String[] args) {
        Observable<String> observable1 = Observable.interval(1, TimeUnit.SECONDS)
                .map(i -> "Source 1: " + (i + 1) + " second(s) passed");

        Observable<String> observable2 = Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(i -> "Source 2: " + ((i + 1) * 300) + " milliseconds passed");

        Observable.merge(observable1, observable2)
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
