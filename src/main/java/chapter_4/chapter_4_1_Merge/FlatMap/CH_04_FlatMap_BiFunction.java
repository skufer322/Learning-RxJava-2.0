package chapter_4.chapter_4_1_Merge.FlatMap;

import io.reactivex.Observable;

public class CH_04_FlatMap_BiFunction {

    public static void main(String[] args) {
        Observable<String> source = Observable.just("Alpha", "Beta", "Gamma");

        source.flatMap((t -> Observable.fromArray(t.split(""))), (t, u) -> t + "-" + u)
                .subscribe(System.out::println);
    }
}
