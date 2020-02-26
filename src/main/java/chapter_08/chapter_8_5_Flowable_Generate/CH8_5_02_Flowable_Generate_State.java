package chapter_08.chapter_8_5_Flowable_Generate;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.atomic.AtomicInteger;

public class CH8_5_02_Flowable_Generate_State {

    public static void main(String[] args) {
        int lowerBound = -100;
        Flowable.generate(() -> new AtomicInteger(100), // seed status
                (state, emitter) -> { // mit seed status und emitter etwas anfangen
                    int current = state.getAndDecrement();
                    emitter.onNext(current);
                    if (current <= lowerBound) {
                        emitter.onComplete();
                    }
                })
                .subscribeOn(Schedulers.io())
                .doOnNext(i -> System.out.println("Emitting " + i))
                .observeOn(Schedulers.computation())
                .subscribe(i -> {
                    sleep(50);
                    System.out.println("Received " + i);
                });

        sleep(50_000);
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
