package chapter_04.chapter_4_2_Concat.ConcatMap;

import io.reactivex.Observable;

public class CH_02_ConcatMap_BiFunction {

    public static void main(String[] args) {
        Observable<String> source = Observable.just("Alpha", "Beta", "Gamma");

        source.flatMap((t -> Observable.fromArray(t.split(""))), (t, u) -> t + "-" + u)
                .subscribe(System.out::println);

        // für concatMap gibt es keine BiFunction
//        source.concatMap((t -> Observable.fromArray(t.split(""))), (t, u) -> t + "-" + u)
//                .subscribe(System.out::println);
    }
}
