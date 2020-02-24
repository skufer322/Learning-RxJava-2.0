package chapter_4.chapter_4_1_Merge.FlatMap;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

// wenn Observable Listen von Items enthält, man aber auf den einzelnen Items arbeiten will
// Observable<List<Item>> -> Observable<Item>
public class CH_05_FlatMapIterable {

    public static void main(String[] args){
        Observable<List<String>> observable = Observable.just(Arrays.asList("Alpha", "Beta", "Gamma"), Arrays.asList("Delta", "Epsilon"));

        Observable<String> flatted = observable.flatMapIterable(list -> list);
        flatted.subscribe(System.out::println);
    }
}
