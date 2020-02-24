package chapter_6.chapter_6_1_RxConcurrency;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;

public class CH6_1_03_Concurrency_Zip {

    public static void main(String[] args) {
        Observable<String> observable1 = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .subscribeOn(Schedulers.computation())
                .map(s -> longRunningFunction(s));

        Observable<Integer> observable2 = Observable.just(1, 2, 3, 4, 5, 6, 7, 8)
                .subscribeOn(Schedulers.newThread())
                .map(i -> longRunningFunction(i));

        Observable.zip(observable1, observable2, (s, i) -> s + "-" + i)
                .subscribe(System.out::println);

        observable2.scan(10, (accumulator, next) -> next - accumulator)
                .subscribe(System.out::println);

        sleep(15_000);
    }

    private static <T> T longRunningFunction(T value) {
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
