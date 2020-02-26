package chapter_06.chapter_6_1_RxConcurrency;

import io.reactivex.Observable;

import java.util.concurrent.ThreadLocalRandom;

public class CH6_1_01_NoConcurrency {

    public static void main(String[] args){

        Observable.just("Alpha", "Beta", "Gamma", "Delta")
                .map(CH6_1_01_NoConcurrency::longRunningFunction)
                .subscribe(s -> System.out.println("observer 1: " + s));

        Observable.just(1, 2, 3, 4)
                .map(CH6_1_01_NoConcurrency::longRunningFunction)
                .subscribe(i -> System.out.println("observer 2: " + i));
    }

    private static <T> T longRunningFunction(T value){
        sleep(ThreadLocalRandom.current().nextInt(3000));
        return value;
    }

    private static void sleep(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
