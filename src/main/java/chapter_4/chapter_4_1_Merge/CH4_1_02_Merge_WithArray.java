package chapter_4.chapter_4_1_Merge;

import io.reactivex.Observable;

public class CH4_1_02_Merge_WithArray {

    public static void main(String[] args) {
        Observable<String> observable1 = Observable.just("Alpha", "Beta");
        Observable<String> observable2 = Observable.just("Gamma", "Delta");
        Observable<String> observable3 = Observable.just("Epsilon", "Zeta");
        Observable<String> observable4 = Observable.just("Eta", "Theta");
        Observable<String> observable5 = Observable.just("Iota", "Kappa");

        Observable<String> merged = Observable.mergeArray(observable1, observable2, observable3, observable4, observable5);

        merged.subscribe(System.out::println);
    }
}
