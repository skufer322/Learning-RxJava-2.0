package chapter_3.chapter_3_6_ActionOperators;

import io.reactivex.Observable;

import java.util.Arrays;

public class CH3_6_01_DoOnNext {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .startWith("Omega")
                .doOnNext(s -> System.out.println("Emitting: " + s))
                .map(String::toUpperCase)
                .map(String::toCharArray)
                .subscribe(s -> System.out.println("Received: " + Arrays.toString(s)));
    }
}
