package chapter_4.chapter_4_6_GroupBy;

import io.reactivex.Observable;

public class CH4_6_02_GroupBy_Reduce {

    public static void main(String[] args){
        Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        observable.groupBy(String::length)
                .flatMapSingle(grp ->
                        grp.reduce("", (accumulator, next) -> accumulator.equals("") ? next : accumulator + ", " + next)
                            .map(s -> grp.getKey() + ": " + s)
                )
                .subscribe(System.out::println);
    }
}
