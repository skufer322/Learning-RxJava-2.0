package chapter_4.chapter_4_1_Merge.FlatMap;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CH_03_FlatMap_ThirdExample {

    public static void main(String[] args) {
        Observable.just(2, 3, 10, 7)
                .flatMap(baseVal -> Observable.interval(baseVal, TimeUnit.SECONDS)
                        .map(numPeriodVal -> (baseVal) + "s interval: " + ((numPeriodVal + 1) * baseVal) + " seconds passed"))
                .subscribe(System.out::println);

        sleep(10);
    }

    private static void sleep(int seconds){
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
