package chapter_07.chapter_7_2_Windowing;

import io.reactivex.Observable;

public class CH7_2_01_Windowing {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Eta")
                .window(3)
                .flatMapSingle(stringObservable ->
                        stringObservable.reduce("", (accumulator, next) -> accumulator.equals("") ? next : accumulator + "|" + next)
                )
                .subscribe(System.out::println);
    }
}
