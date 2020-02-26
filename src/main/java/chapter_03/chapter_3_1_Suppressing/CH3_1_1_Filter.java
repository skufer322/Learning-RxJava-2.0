package chapter_03.chapter_3_1_Suppressing;

import io.reactivex.Observable;

public class CH3_1_1_Filter {

    public static void main(String[] args){
        Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        observable.filter(s -> s.length() == 5)
                .subscribe(System.out::println);
    }
}
