package chapter_6.chapter_6_2_Schedulers;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CH6_2_01_Schedulers_Computation {

    public static void main(String[] args){
        Observable.just("Alpha", "Beta", "Gamma")
                .subscribeOn(Schedulers.computation())
                .map(s -> longRunningMethod(s))
                .subscribe(s -> System.out.println("observer 1: " + s + "    [on thread: " + Thread.currentThread().getName() + "]"));

        Observable.just(1, 2, 3, 4, 5)
                .subscribeOn(Schedulers.computation())
                .map(i -> longRunningMethod(i))
                .subscribe(s -> System.out.println("observer 2: " + s + "    [on thread: " + Thread.currentThread().getName() + "]"));

        Observable.just(List.of("Delta", "Epsilon"), List.of("Zeta", "Eta", "Theta"))
                .subscribeOn(Schedulers.computation())
                .map(s -> longRunningMethod(s))
                .flatMapIterable(list -> list)
                .subscribe(s -> System.out.println("observer 3: " + s + "    [on thread: " + Thread.currentThread().getName() + "]"));

        Observable.just(9, 8, 7, 5, 4)
                .subscribeOn(Schedulers.computation())
                .map(i -> longRunningMethod(i) * 10)
                .subscribe(s -> System.out.println("observer 4: " + s + "    [on thread: " + Thread.currentThread().getName() + "]"));

        sleep(15_000);
    }

    private static <T> T longRunningMethod(T value){
        sleep(ThreadLocalRandom.current().nextInt(3000));
        return value;
    }

    private static void sleep(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
