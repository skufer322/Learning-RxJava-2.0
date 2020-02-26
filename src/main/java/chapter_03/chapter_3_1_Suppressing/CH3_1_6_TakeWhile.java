package chapter_03.chapter_3_1_Suppressing;

import io.reactivex.Observable;

public class CH3_1_6_TakeWhile {

    public static void main(String[] args){
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Iota")
                .takeWhile(s -> s.length() < 7)
                .subscribe(System.out::println);
    }
}
