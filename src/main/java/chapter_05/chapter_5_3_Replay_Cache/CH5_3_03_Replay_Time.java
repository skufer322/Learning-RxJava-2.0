package chapter_05.chapter_5_3_Replay_Cache;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CH5_3_03_Replay_Time {

    public static void main(String[] args) {
        Observable<Long> replayTime = Observable.interval(1, TimeUnit.SECONDS)
                .replay(2, TimeUnit.SECONDS)
                .autoConnect();

        replayTime.take(3).subscribe(s -> System.out.println("Observer 1: " + s));
        sleep(5);
        replayTime.subscribe(s -> System.out.println("Observer 2: " + s));
        sleep(5);
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
