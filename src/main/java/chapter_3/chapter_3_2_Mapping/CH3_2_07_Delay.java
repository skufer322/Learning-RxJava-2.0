package chapter_3.chapter_3_2_Mapping;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CH3_2_07_Delay {

    public static void main(String[] args){
        Observable.just("Alpha", "Beta", "Gamma")
            .delay(2, TimeUnit.SECONDS)
            .subscribe(System.out::println);

        sleep(3);
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
