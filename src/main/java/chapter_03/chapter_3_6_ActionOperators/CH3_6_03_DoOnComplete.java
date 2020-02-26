package chapter_03.chapter_3_6_ActionOperators;

import io.reactivex.Observable;

public class CH3_6_03_DoOnComplete {

    public static void  main(String[] args){
        Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .doOnComplete(() -> System.out.println("Just completed!"))
                .map(String::toUpperCase);

        observable.subscribe(System.out::println);

        observable.subscribe( s -> System.out.println("received2: " + s));
    }
}
