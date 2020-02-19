package chapter_4.chapter_4_2_Concat;

import io.reactivex.Observable;

public class CH4_2_01_Concat {

    public static void main(String[] args){
        Observable<String> observable1 = Observable.just("Alpha", "Beta", "Gamma");
        Observable<String> observable2 = Observable.just("Delta", "Epsilon", "Zeta");

        Observable.concat(observable1, observable2)
                .subscribe(System.out::println);
    }
}
