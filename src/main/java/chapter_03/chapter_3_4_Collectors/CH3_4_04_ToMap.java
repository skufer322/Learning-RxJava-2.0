package chapter_03.chapter_3_4_Collectors;

import io.reactivex.Observable;

import java.util.concurrent.ConcurrentHashMap;

public class CH3_4_04_ToMap {

    public static void main(String[] args){
        Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Eta", "Theta", "Iota", "Kappa");

        observable.toMap(string -> string.charAt(0))
                .subscribe(map -> System.out.println("mapped to first char: " + map));

        observable.toMap(String::length)
                .subscribe(map -> System.out.println("mapped to string length: " + map));

        observable.toMap(string -> string.charAt(0), String::length, ConcurrentHashMap::new)
                .subscribe(map -> System.out.println("mapped string length to first char in ConcurrentHashMap: " + map));
    }
}
