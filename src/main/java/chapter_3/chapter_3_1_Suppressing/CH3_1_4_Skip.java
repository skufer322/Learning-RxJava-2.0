package chapter_3.chapter_3_1_Suppressing;

import io.reactivex.Observable;

public class CH3_1_4_Skip {

    public static void main(String[] args){
        Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        observable.skip(3).subscribe(System.out::println);
        System.out.println();
        observable.skip(10).subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("done"));
    }
}
