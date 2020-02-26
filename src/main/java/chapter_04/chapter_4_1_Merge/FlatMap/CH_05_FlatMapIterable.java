package chapter_04.chapter_4_1_Merge.FlatMap;

import io.reactivex.Observable;

import java.util.List;

// wenn Observable Listen von Items enthält, man aber auf den einzelnen Items arbeiten will
// Observable<List<Item>> -> Observable<Item>
public class CH_05_FlatMapIterable {

    public static void main(String[] args){
        Observable<List<String>> observable = Observable.just(List.of("Alpha", "Beta", "Gamma"), List.of("Delta", "Epsilon"));

        Observable<String> flatted = observable.flatMapIterable(list -> list);
        flatted.subscribe(System.out::println);
    }
}
