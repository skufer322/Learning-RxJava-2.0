package chapter_4.chapter_4_1_Merge.FlatMap;

import io.reactivex.Observable;

import java.util.Arrays;

public class CH_01_FlatMap {

    public static void main(String[] args) {
        Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        source.flatMap(s -> Observable.just(s, "inBetween"))
                .subscribe(System.out::println);

        System.out.println();

        source.flatMap(s -> Observable.fromIterable(Arrays.asList(s.split(""))))
                .subscribe(System.out::println);
    }
}
