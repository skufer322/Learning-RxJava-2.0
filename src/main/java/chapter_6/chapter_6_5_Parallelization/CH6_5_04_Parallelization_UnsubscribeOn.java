package chapter_6.chapter_6_5_Parallelization;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class CH6_5_04_Parallelization_UnsubscribeOn {

    public static void main(String[] args){
        Disposable d1 = Observable.interval(1, TimeUnit.SECONDS)
                .doOnDispose(() -> System.out.println("Disposing Observable 1 on thread " + Thread.currentThread().getName()))
                .subscribe(l -> System.out.println("Observer 1: " + l));

        sleep(3_000);
        d1.dispose();

        Disposable d2 = Observable.interval(1, TimeUnit.SECONDS)
                .doOnDispose(() -> System.out.println("Disposing Observable 2 on thread " + Thread.currentThread().getName()))
                .unsubscribeOn(Schedulers.newThread())
                .subscribe(l -> System.out.println("Observer 2: " + l));

        sleep(3_000);
        d2.dispose();
        sleep(50);
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
