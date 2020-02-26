package chapter_04.chapter_4_2_Concat.ConcatMap;

import io.reactivex.Observable;

public class CH_01_ConcatMap {

    public static void main(String[] args) {
        Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma");

        observable.concatMap(s -> Observable.fromArray(s.split("")))
                .subscribe(System.out::println);
    }
}
