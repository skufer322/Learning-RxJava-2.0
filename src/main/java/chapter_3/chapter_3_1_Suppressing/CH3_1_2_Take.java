package chapter_3.chapter_3_1_Suppressing;

import io.reactivex.Observable;

public class CH3_1_2_Take {

    public static void main(String[] args){
        Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        observable.take(3).subscribe(System.out::println);
        System.out.println();
        observable.take(100).subscribe(System.out::println);
    }
}
