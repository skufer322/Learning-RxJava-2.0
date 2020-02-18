package chapter_3.chapter_3_1_Suppressing;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CH3_1_5_Skip_Time {

    public static void main(String[] args){
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .skip(2, TimeUnit.SECONDS)
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("done"));

        sleep(4);
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
