package chapter_3.chapter_3_4_Collectors;

import io.reactivex.Observable;

public class CH3_4_05_ToMultiMap {

    public static void main(String[] args){
        Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Eta", "Theta", "Iota", "Kappa");

        observable.toMultimap(String::length)
                .subscribe(map -> System.out.println("multimap per string length: " + map));
    }
}
