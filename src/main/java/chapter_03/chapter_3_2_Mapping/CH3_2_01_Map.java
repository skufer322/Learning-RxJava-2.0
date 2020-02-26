package chapter_03.chapter_3_2_Mapping;

import io.reactivex.Observable;

public class CH3_2_01_Map {

    public static void main(String[] args){
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .map(String::length)
                .subscribe(System.out::println);
    }
}
