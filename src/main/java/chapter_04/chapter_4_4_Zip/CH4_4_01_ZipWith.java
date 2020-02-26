package chapter_04.chapter_4_4_Zip;

import io.reactivex.Observable;

public class CH4_4_01_ZipWith {

    public static void main(String[] args) {
        Observable<String> observable1 = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        Observable<Long> observable2 = Observable.rangeLong(1, 10);

        Observable.zip(observable1, observable2, (s,l) -> s + "-" + l)
                .subscribe(System.out::println);
    }
}
