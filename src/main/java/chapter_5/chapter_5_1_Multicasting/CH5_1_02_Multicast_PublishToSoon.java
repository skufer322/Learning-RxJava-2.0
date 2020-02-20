package chapter_5.chapter_5_1_Multicasting;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.ThreadLocalRandom;

public class CH5_1_02_Multicast_PublishToSoon {

    public static void main(String[] args) {
        ConnectableObservable<Integer> hotObservable = Observable.range(1, 3)
                .publish();

        Observable<Integer> coldObservableAgain = hotObservable.map(i -> nextRandom());

        coldObservableAgain.subscribe(i -> System.out.println("Observer 1:" + i));
        coldObservableAgain.subscribe(i -> System.out.println("Observer 2:" + i));

        hotObservable.connect();
    }

    private static int nextRandom() {
        return ThreadLocalRandom.current().nextInt(1_000);
    }
}
