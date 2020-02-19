package chapter_3.chapter_3_6_ActionOperators;

import io.reactivex.Maybe;
import io.reactivex.Single;

public class CH3_6_07_DoOnSuccess {

    public static void main(String[] args) {
        Single<String> single = Single.just("Alpha")
                .doOnSuccess(item -> System.out.println("processing: " + item + "!"));
        single.map(String::toUpperCase)
                .subscribe(System.out::println);
        System.out.println();

        Maybe<String> emptyMaybe = Maybe.empty();
        emptyMaybe.doOnSuccess(s -> System.out.println("processing: " + s))
                .map(String::toUpperCase)
                .doOnComplete(() -> System.out.println("done with emptyMaybe"))
                .subscribe(System.out::println);
        System.out.println();

        Maybe<String> filledMaybe = Maybe.just("Omega");
        filledMaybe.doOnSuccess(s -> System.out.println("processing: " + s))
                .map(String::toUpperCase)
                .doOnComplete(() -> System.out.println("done with filledMaybe"))
                .doFinally(() -> System.out.println("Finally done with filledMaybe"))
                .subscribe(System.out::println);
    }
}
