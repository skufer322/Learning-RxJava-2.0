package chapter_08.chapter_8_3_CreatingFlowables;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;

public class CH8_3_02_Flowable_ObservableToFlowable {

    public static void main(String[] args) {
        Observable<Integer> source = Observable.range(1, 1_000);
        source.toFlowable(BackpressureStrategy.LATEST)
                .doOnNext(i -> System.out.println("DoOnNext " + i))
                .observeOn(Schedulers.io())
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
