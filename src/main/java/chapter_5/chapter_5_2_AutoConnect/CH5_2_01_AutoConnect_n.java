package chapter_5.chapter_5_2_AutoConnect;

import io.reactivex.Observable;

import java.util.concurrent.ThreadLocalRandom;

public class CH5_2_01_AutoConnect_n {

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.range(1, 3)
                .map(i -> nextRandom())
                .publish()
                .autoConnect(2);

        observable.subscribe(i -> System.out.println("Observer 1: " + i));
        observable.reduce(0, (accumulator, next) -> accumulator + next)
                .subscribe(i -> System.out.println("Observer 2: " + i));

        // observer 3 bekommt nichts
        observable.subscribe(i -> System.out.println("Observer 3: " + i));
    }

    private static int nextRandom() {
        return ThreadLocalRandom.current().nextInt(1_000);
    }
}
