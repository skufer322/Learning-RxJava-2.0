package chapter_08.chapter_8_3_CreatingFlowables;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;

public class CH8_3_01_Flowable_Create {

    public static void main(String[] args) {
        Flowable<Integer> source = Flowable.create(emitter -> {
                    for (int i = 0; i < 1_000; i++) {
                        if (emitter.isCancelled()) {
                            return;
                        } else {
                            emitter.onNext(i);
                        }
                    }
                    emitter.onComplete();
                }, BackpressureStrategy.LATEST
        );

        source.observeOn(Schedulers.io())
                .map(i -> intenseCalculation(i))
                .subscribe(i -> System.out.println("Received " + i));

        sleep(20_000);
    }

    private static <T> T intenseCalculation(T value){
        sleep(ThreadLocalRandom.current().nextInt(200));
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
