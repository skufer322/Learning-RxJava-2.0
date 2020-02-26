package chapter_08.chapter_8_2_FlowableAndSubscriber;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;

public class CH8_2_02_FlowableAndSubscriber_SubscriberLambdas {

    public static void main(String[] args) {
        // sync-Variante
        Flowable.range(1, 150)
                .doOnNext(i -> System.out.println("Flowable pushed " + i))
                .observeOn(Schedulers.io())
                .map(i -> intenseCalculation(i))
                .subscribe(i -> System.out.println("Subscriber received " + i), Throwable::printStackTrace, () -> System.out.println("Done"));

        // async-Variante
//        ExecutorService executor = Executors.newFixedThreadPool(4);
//        Flowable.range(1, 150)
//                .doOnNext(i -> System.out.println("Flowable pushed " + i))
//                .flatMap(i ->
//                        Flowable.just(i)
//                                .subscribeOn(Schedulers.from(executor))
//                                .map(i -> intenseCalculation(i))
//                )
//                .subscribe(i -> System.out.println("Subscriber received " + i), Throwable::printStackTrace, () -> System.out.println("Done"));
//        executor.shutdown();

        sleep(20_000);
    }


    private static <T> T intenseCalculation(T value) {
        sleep(ThreadLocalRandom.current().nextInt(200));
        return value;
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
