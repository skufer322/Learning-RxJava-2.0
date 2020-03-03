package chapter_10.chapter_10_4_TestScheduler;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class CH10_4_02_TestClass_ReplaceScheduler {

    public Observable<String> doSth_SameThreadAsInput(Observable<Long> input) {
        return input.map(i -> i + " now a String on thread " + Thread.currentThread().getName());
    }

    public Observable<String> doSth_Parallelize(Observable<Long> input) {
        return input
                .flatMap(i -> Observable.just(i)
                        .subscribeOn(Schedulers.computation())
                        .map(i2 -> i + " now a String on thread " + Thread.currentThread().getName())
                );
    }

    public Observable<String> doSth_Parallelize_IntenseCalculation(Observable<Long> input) {
        return input
                .flatMap(i -> Observable.just(i)
                        .subscribeOn(Schedulers.computation())
                        .map(i2 -> intenseCalculation(i2))
                );
    }

    public Observable<Long> doSth_SecondIntervalThread(Observable<Long> input) {
        return input
                .flatMap(l ->
                        Observable.just(l)
                                .observeOn(Schedulers.io())
                                .zipWith(Observable.interval(500, TimeUnit.MILLISECONDS), (l1, l2) -> l1 * 10)
                );
    }

    private static <T> String intenseCalculation(T value) {
        sleep();
        return value + "  now a String on thread " + Thread.currentThread().getName();
    }

    private static void sleep() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
