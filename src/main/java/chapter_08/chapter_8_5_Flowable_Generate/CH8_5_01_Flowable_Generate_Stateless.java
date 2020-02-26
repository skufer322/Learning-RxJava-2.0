package chapter_08.chapter_8_5_Flowable_Generate;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;

public class CH8_5_01_Flowable_Generate_Stateless {

    public static void main(String[] args) {
        Flowable.generate(emitter -> {
                    emitter.onNext(ThreadLocalRandom.current().nextInt(1_000));
                })
                .subscribeOn(Schedulers.computation())
                .doOnNext(i -> System.out.println("Emitting " + i))
                .observeOn(Schedulers.io())
                .subscribe(i -> {
                    sleep(50);
                    System.out.println("Received: " + i);
                });

        sleep(10_000);
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
