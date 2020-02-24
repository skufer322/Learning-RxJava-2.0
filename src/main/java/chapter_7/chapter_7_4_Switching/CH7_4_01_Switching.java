package chapter_7.chapter_7_4_Switching;

import io.reactivex.Observable;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class CH7_4_01_Switching {

    public static void main(String[] args) {
        Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Eta", "Theta");

        Observable<String> observable2 = observable.concatMap(s ->
                Observable.just(s).delay(randomSleepTime(), TimeUnit.MILLISECONDS)
        );

        Observable.interval(5, TimeUnit.SECONDS)
                .switchMap(l ->
                        observable2.doOnDispose(() -> System.out.println("Disposed current Observable!")))
                .subscribe(System.out::println);

        sleep(40_000);
    }

    private static int randomSleepTime() {
        return ThreadLocalRandom.current().nextInt(2_000);
    }

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
