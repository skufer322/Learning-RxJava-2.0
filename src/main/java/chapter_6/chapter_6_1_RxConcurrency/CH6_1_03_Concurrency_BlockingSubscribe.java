package chapter_6.chapter_6_1_RxConcurrency;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;

/**
 * blockingSubscribe sorgt dafür, dass alles im main thread ausgeführt wird
 */
public class CH6_1_03_Concurrency_BlockingSubscribe {

    public static void main(String[] args) {

        Observable.just("Alpha", "Beta", "Gamma", "Delta")
                .subscribeOn(Schedulers.computation())
                .map(CH6_1_03_Concurrency_BlockingSubscribe::longRunningFunction)
                .blockingSubscribe(i -> System.out.println("observer 1: " + i + "   [on thread " + Thread.currentThread().getName() + "]"));
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
