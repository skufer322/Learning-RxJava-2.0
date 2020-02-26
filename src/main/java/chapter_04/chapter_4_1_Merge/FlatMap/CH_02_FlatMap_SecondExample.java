package chapter_04.chapter_4_1_Merge.FlatMap;

import io.reactivex.Observable;

public class CH_02_FlatMap_SecondExample {

    public static void main(String[] args) {
        Observable<String> source = Observable.just("5253/747327/WHISKEY/2652", "TANGO/61284681/52/327", "853848/436/FOXTROT");

        source.flatMap(s -> Observable.fromArray(s.split("/")))
                .filter(s -> s.matches("\\d+"))
                .map(Integer::valueOf)
                .subscribe(System.out::println);

        System.out.println();

        source.flatMap(s -> Observable.fromArray(s.split("/")))
                .filter(s -> s.matches("\\d+"))
                .map(Integer::valueOf)
                .doOnNext(val -> System.out.println("processing: " + val))
                .reduce(Integer::sum)
                .subscribe(System.out::println);
    }
}
