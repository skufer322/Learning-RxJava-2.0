package chapter_07.chapter_7_1_Buffering;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CH7_1_05_Buffering_TimeBased_MaxBufferSize {

    public static void main(String[] args){
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .buffer(1, TimeUnit.SECONDS, 2)
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
