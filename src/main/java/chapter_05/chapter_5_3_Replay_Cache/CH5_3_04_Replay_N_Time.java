package chapter_05.chapter_5_3_Replay_Cache;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * entspricht min{n, |emissions in timeUnit|}
 */
public class CH5_3_04_Replay_N_Time {

    public static void main(String[] args) {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS)
                .replay(2, 3, TimeUnit.SECONDS)
                .autoConnect();

        observable.take(2).subscribe(s -> System.out.println("Observer 1: " + s));
        sleep(3);
        observable.take(4).subscribe(s -> System.out.println("Observer 2: " + s));
        sleep(3);

        Observable<Long> observable2 = Observable.interval(1, TimeUnit.SECONDS)
                .replay(3, 2, TimeUnit.SECONDS)
                .autoConnect();

        observable2.take(2).subscribe(s -> System.out.println("Observer 3: " + s));
        sleep(3);
        observable2.subscribe(s -> System.out.println("Observer 4: " + s));
        sleep(3);
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
