package chapter_5.chapter_5_2_AutoConnect;

import io.reactivex.Observable;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class CH5_2_02_AutoConnect {

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.interval(1, TimeUnit.SECONDS)
                .map(i -> nextRandom())
                .publish()
                .autoConnect();

        observable.subscribe(i -> System.out.println("Observer 1: " + i));

        sleep(3);

        observable.subscribe(i -> System.out.println("Observer 2: " + i));

        sleep(5);
    }

    private static int nextRandom() {
        return ThreadLocalRandom.current().nextInt(1_000);
    }

    private static void sleep(int seconds){
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
