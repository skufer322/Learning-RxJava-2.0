package chapter_06.chapter_6_2_Schedulers;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class CH6_2_05_Schedulers_ExecutorService {

    public static void main(String[] args) {

        int numberOfThreads = 10;

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        Observable<String> observable1 = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .subscribeOn(Schedulers.from(executorService))
                .map(s -> longRunningMethod(s));
        Disposable disposable1 = observable1.subscribe(s -> System.out.println("Observer 1: " + s + " on thread " + Thread.currentThread().getName()));

        Observable<String> observable2 = Observable.just("Zeta", "Eta", "Theta", "Iota", "Kappa", "Lambda")
                .subscribeOn(Schedulers.from(executorService))
                .map(s -> longRunningMethod(s));
        Disposable disposable2 = observable2.subscribe(s -> System.out.println("Observer 2: " + s + " on thread " + Thread.currentThread().getName()));

        Observable<Integer> observable3 = Observable.just(1, 2, 3, 4, 5, 6, 7)
                .subscribeOn(Schedulers.from(executorService))
                .map(i -> longRunningMethod(i));
        Disposable disposable3 = observable3.subscribe(i -> System.out.println("Observer 3: " + i + " on thread " + Thread.currentThread().getName()));

        Observable<Long> observable4 = Observable.just(10L, 20L, 30L, 40L, 50L, 60L, 70L)
                .subscribeOn(Schedulers.from(executorService))
                .map(i -> longRunningMethod(i));
        Disposable disposable4 = observable4.subscribe(i -> System.out.println("Observer 4: " + i + " on thread " + Thread.currentThread().getName()));

        while (!(disposable1.isDisposed() && disposable2.isDisposed() && disposable3.isDisposed() && disposable4.isDisposed())){
            sleep(1_000);
        }

        executorService.shutdown();
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
