package chapter_06.chapter_6_3_SubscribeOn;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;

public class CH6_3_01_SubscribeOn_MultipleObservers {

    public static void main(String[] args){

        Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .subscribeOn(Schedulers.computation())
                .map(s -> longRunningMethod(s));

        observable.subscribe(s -> System.out.println("Observer 1: " + s + " - on thread " + Thread.currentThread().getName()));
        observable.subscribe(s -> System.out.println("Observer 2: " + s + " - on thread " + Thread.currentThread().getName()));

        sleep(10_000);
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
