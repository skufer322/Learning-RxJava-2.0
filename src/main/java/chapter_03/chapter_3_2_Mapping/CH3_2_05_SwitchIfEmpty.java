package chapter_03.chapter_3_2_Mapping;

import io.reactivex.Observable;

public class CH3_2_05_SwitchIfEmpty {

    public static void main(String[] args) {
        Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma");

        Observable.just("Omega")
                .switchIfEmpty(observable)
                .subscribe(System.out::println);

        System.out.println();

        Observable.empty()
                .switchIfEmpty(observable)
                .subscribe(System.out::println);
    }
}
