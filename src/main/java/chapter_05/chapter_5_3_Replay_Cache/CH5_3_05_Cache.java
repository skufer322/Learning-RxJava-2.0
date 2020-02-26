package chapter_05.chapter_5_3_Replay_Cache;

import io.reactivex.Observable;

public class CH5_3_05_Cache {

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.just(3, 7, 2, 1, 8, 4)
                .scan(0, (accumulator, next) -> {
                    sleep(500);
                    return accumulator + next;
                })
                .cache();

        observable.subscribe(i -> System.out.println("Observer 1: " + i));
        observable.subscribe(i -> System.out.println("Observer 2 " + i));
    }

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
