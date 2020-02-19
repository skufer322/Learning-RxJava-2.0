package chapter_3.chapter_3_3_Reducing;

import io.reactivex.Observable;

public class CH3_3_02_Reduce {

    public static void main(String[] args){
        Observable.just("Alpha", "Beta", "Gamma")
                .reduce("start", (accumulator, next) -> String.join(":", next, accumulator))
                .subscribe(s -> System.out.println("final emission: " + s));
    }
}
