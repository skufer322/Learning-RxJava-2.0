package chapter_3.chapter_3_1_Suppressing;

import io.reactivex.Observable;

public class CH3_1_09_DistinctUntilChanged {

    public static void main(String[] args){
        Observable.just(1, 1, 2, 3, 3, 3, 2, 1, 1, 1)
                .distinctUntilChanged()
                .subscribe(System.out::println);

        System.out.println();

        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Iota")
                .distinctUntilChanged(String::length)
                .subscribe(System.out::println);
    }
}
