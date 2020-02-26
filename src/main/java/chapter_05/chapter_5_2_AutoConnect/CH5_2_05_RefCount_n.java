package chapter_05.chapter_5_2_AutoConnect;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CH5_2_05_RefCount_n {

    public static void main(String[] args){
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS)
                .publish()
                .refCount(3);

        observable.take(1).subscribe(i -> System.out.println("Observer 1: " + i));
        observable.take(2).subscribe(i -> System.out.println("Observer 2: " + i));
        observable.take(3).subscribe(i -> System.out.println("Observer 3: " + i));

        sleep(5);

        observable.take(1).subscribe(i -> System.out.println("Observer 4: " + i));

        System.out.println("schnarche noch zwei sekunden!");
        sleep(2);

        observable.take(2).subscribe(i -> System.out.println("Observer 5: " + i));
        observable.take(3).subscribe(i -> System.out.println("Observer 6: " + i));

        sleep(5);

    }

    private static void sleep(int seconds){
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
