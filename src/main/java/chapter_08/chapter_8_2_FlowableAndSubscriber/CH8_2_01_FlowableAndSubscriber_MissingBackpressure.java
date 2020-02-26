package chapter_08.chapter_8_2_FlowableAndSubscriber;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class CH8_2_01_FlowableAndSubscriber_MissingBackpressure {

    public static void main(String[] args){
        Flowable.interval(1, TimeUnit.MILLISECONDS)
                .observeOn(Schedulers.io())
                .map(i -> intenseCalculation(i))
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("done"));

        sleep(Integer.MAX_VALUE);
    }

    private static <T> T intenseCalculation(T value){
        sleep(ThreadLocalRandom.current().nextInt(3_000));
        return value;
    }

    private static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
