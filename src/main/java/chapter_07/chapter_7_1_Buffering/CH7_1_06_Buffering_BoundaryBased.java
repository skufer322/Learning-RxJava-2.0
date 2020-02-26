package chapter_07.chapter_7_1_Buffering;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CH7_1_06_Buffering_BoundaryBased {

    public static void main(String[] args){
        Observable<Long> observable1 = Observable.interval(1, TimeUnit.SECONDS);

        Observable.interval(300, TimeUnit.MILLISECONDS)
                .buffer(observable1)
                .subscribe(System.out::println);

        sleep(10_000);
    }

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
