package chapter_03.chapter_3_2_Mapping;

import io.reactivex.Observable;

import java.util.Arrays;

public class CH3_2_03_StartWith_StartWithArray {

    public static void main(String[] args){
        Observable.just("Alpha", "Beta", "Gamma")
                .startWith("Omega")
                .subscribe(System.out::println);
        System.out.println();

        Observable<String> observable = Observable.just("TA", "DK", "SF");
        Observable.just("Weaver", "Troll", "Doom")
                .startWith(observable)
                .startWith(Arrays.asList("Zeus", "Night Stalker"))
                .startWithArray("1", "2")
                .subscribe(System.out::println);
    }
}
