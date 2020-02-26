package chapter_06.chapter_6_2_Schedulers;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class CH6_2_04_Schedulers_Single {

    public static void main(String[] args) {

        Observable.just("Alpha", "Beta", "Gamma")
                .subscribeOn(Schedulers.single())
                .map(s -> longRunningMethod(s))
                .subscribe(s -> System.out.println("observer 1: " + s + "   [on thread - " + Thread.currentThread().getName() + "]"));

        Observable.interval(1, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.single())
                .take(4)
                .map(l -> longRunningMethod(l))
                .subscribe(s -> System.out.println("observer 2: " + s + "   [on thread - " + Thread.currentThread().getName() + "]"));

        sleep(15_000);
    }

    private static <T> T longRunningMethod(T value) {
        sleep(ThreadLocalRandom.current().nextInt(3000));
        return value;
    }

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
