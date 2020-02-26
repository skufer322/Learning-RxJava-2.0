package chapter_02;

import io.reactivex.Observable;
import io.reactivex.Single;

public class CH2_14_Single {

    public static void main(String[] args) {
        Single<String> single = Single.just("Alpha");
        single.subscribe(s -> System.out.println("single value: " + s), Throwable::printStackTrace);
        System.out.println();

        Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma");
        Single<String> single2 = observable.first("Default");
        single2.subscribe(s -> System.out.println("first value from observable: " + s));
        System.out.println();

        Observable<String> empty = Observable.empty();
        Single<String> single3 = empty.first("Default");
        single3.subscribe(s -> System.out.println("first item from empty: " + s));
    }
}
