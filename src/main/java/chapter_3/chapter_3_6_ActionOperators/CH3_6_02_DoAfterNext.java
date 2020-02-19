package chapter_3.chapter_3_6_ActionOperators;

import io.reactivex.Observable;

public class CH3_6_02_DoAfterNext {

    public static void  main(String[] args){
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .doAfterNext(s -> System.out.println("Just emitted: " + s))
                .map(String::toUpperCase)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}
