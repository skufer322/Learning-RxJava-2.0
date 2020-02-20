package chapter_5.chapter_5_1_Multicasting;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.ThreadLocalRandom;

public class CH5_1_03_Multicast {

    public static void main(String[] args) {
        ConnectableObservable<Integer> connectableObservable = Observable.range(1, 3)
                .map(i -> nextRandom())
                .publish();

        connectableObservable.subscribe(i -> System.out.println("Observer 1: " + i));
        connectableObservable.subscribe(i -> System.out.println("Observer 2: " + i));

        connectableObservable.connect();
    }

    private static int nextRandom() {
        return ThreadLocalRandom.current().nextInt(1_000);
    }
}
