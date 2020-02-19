package chapter_4.chapter_4_4_Zip;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CH4_4_02_ZipWith_OneObserverInterval {

    public static void main(String[] args) {
        Observable<String> observable1 = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        Observable<Long> observable2 = Observable.interval(1, TimeUnit.SECONDS);

        Observable.zip(observable1, observable2, (s, l) -> s + "-" + l)
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
