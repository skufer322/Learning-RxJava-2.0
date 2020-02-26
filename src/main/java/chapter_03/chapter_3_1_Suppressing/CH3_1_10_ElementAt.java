package chapter_03.chapter_3_1_Suppressing;

import io.reactivex.Maybe;
import io.reactivex.Observable;

public class CH3_1_10_ElementAt {

    public static void main(String[] args){
        Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Iota");

        Maybe<String> maybe1 = observable
                .elementAt(3);
        maybe1.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("maybe1 done"));

        System.out.println();

        Maybe<String> maybe2 = observable
                .elementAt(Integer.MAX_VALUE);
        maybe2.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("maybe2 done"));
    }
}
