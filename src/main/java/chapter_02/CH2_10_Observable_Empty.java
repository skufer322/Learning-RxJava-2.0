package chapter_02;

import io.reactivex.Observable;

public class CH2_10_Observable_Empty {

    public static void main(String[] args) {
        Observable<String> observable = Observable.empty();

        observable.subscribe(s -> System.out.println("received: " + s), Throwable::printStackTrace, () -> System.out.println("Done"));

        System.out.println("main thread going to sleep");
        sleep(5);
        System.out.println("main thread is awake again");
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
