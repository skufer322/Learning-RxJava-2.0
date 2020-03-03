package chapter_02;

import io.reactivex.Observable;

import java.util.ArrayList;

public class CH2_12_Observable_FromCallable {

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.fromCallable(() -> {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(1);
                result.add(2);
                result.add(3);
                return result;
            })
            .flatMapIterable(list -> list);

        observable.subscribe(System.out::println);


        Observable<Integer> obs1 = Observable.just(1);
        Observable<String> obs2 = Observable.just("a");
        Observable<Long> obs3 = Observable.just(0L);
    }
}
