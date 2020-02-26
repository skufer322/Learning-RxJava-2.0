package chapter_08.chapter_8_3_CreatingFlowables;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class CH8_3_03_Flowable_FlowableToObservable {

    public static void main(String[] args){
        Flowable<Integer> flowable = Flowable.range(1, 1000)
                .subscribeOn(Schedulers.computation());

        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .flatMap(s ->
                        flowable.map(i -> s + "-" + i).toObservable())
                .subscribe(s -> System.out.println(s));

        sleep(5_000);
    }

    private static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
