package chapter_6.chapter_6_2_Schedulers;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class CH6_2_02_Schedulers_IO {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma")
                .subscribeOn(Schedulers.io())
                .map(s -> longRunningMethod(s))
                .subscribe(s -> System.out.println("observer 1: " + s + "   [on thread - " + Thread.currentThread().getName() + "]"));

        Observable.interval(1, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .take(4)
                .map(i -> longRunningMethod(i))
                .subscribe(s -> System.out.println("observer 2: " + s + "   [on thread - " + Thread.currentThread().getName() + "]"));

        sleep(12_000);
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
