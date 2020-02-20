package chapter_5.chapter_5_3_Replay_Cache;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CH5_3_01_Replay_All {

    public static void main(String[] args) {
        Observable<Long> noReplay = Observable.interval(1, TimeUnit.SECONDS)
                .take(3)
                .publish()
                .autoConnect();

        // observer2 bekommt nichts
        noReplay.subscribe(s -> System.out.println("Observer 1: " + s));
        sleep(3);
        noReplay.subscribe(s -> System.out.println("Observer 2: " + s));
        sleep(3);

        Observable<Long> replay = Observable.interval(1, TimeUnit.SECONDS)
                .replay()
                .autoConnect();
        // observer4 bekommt emittierte Werte -> die bisher emittierten werden sofort gepusht
        replay.take(2).subscribe(s -> System.out.println("Observer 3: " + s));
        sleep(2);
        replay.take(4).subscribe(s -> System.out.println("Observer 4: " + s));
        sleep(2);

    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
