package chapter_5.chapter_5_2_AutoConnect;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CH5_2_06_Share {

    public static void main(String[] args){
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS)
                .share();
        System.out.println("starte...");
        sleep(2);

        observable.take(1).subscribe(i -> System.out.println("Observer 1: " + i));

        sleep(3);

        observable.take(2).subscribe(i -> System.out.println("Observer 2: " + i));

        sleep(3);

        observable.take(3).subscribe(i -> System.out.println("Observer 3: " + i));
        sleep(2);
        observable.take(4).subscribe(i -> System.out.println("Observer 4: " + i));

        sleep(4);
    }

    private static void sleep(int seconds){
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
