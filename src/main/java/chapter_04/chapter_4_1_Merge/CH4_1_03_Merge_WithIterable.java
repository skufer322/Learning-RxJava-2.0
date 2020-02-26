package chapter_04.chapter_4_1_Merge;

import io.reactivex.Observable;

import java.util.List;

public class CH4_1_03_Merge_WithIterable {

    public static void main(String[] args) {
        Observable<String> observable1 = Observable.just("Alpha", "Beta");
        Observable<String> observable2 = Observable.just("Gamma", "Delta");
        Observable<String> observable3 = Observable.just("Epsilon", "Zeta");
        Observable<String> observable4 = Observable.just("Eta", "Theta");
        Observable<String> observable5 = Observable.just("Iota", "Kappa");

        Observable<String> merged = Observable.merge(List.of(observable1, observable2, observable3, observable4, observable5));

        merged.subscribe(System.out::println);
    }
}
