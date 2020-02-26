package chapter_05.chapter_5_3_Replay_Cache;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CH5_3_02_Replay_N {

    public static void main(String[] args){
        Observable<Long> replayN = Observable.interval(1, TimeUnit.SECONDS)
                .replay(2)
                .autoConnect();

        replayN.take(5).subscribe(s -> System.out.println("Observer 1: " + s));
        sleep(5);
        replayN.take(9).subscribe(s -> System.out.println("Observer 2: " + s));
        sleep(7);
        replayN.subscribe(s -> System.out.println("Observer 3: " + s));
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
