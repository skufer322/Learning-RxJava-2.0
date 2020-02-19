package chapter_3.chapter_3_2_Mapping;

import io.reactivex.Observable;

import java.util.List;

public class CH3_2_03_StartWith_StartWithArray {

    public static void main(String[] args){
        Observable.just("Alpha", "Beta", "Gamma")
                .startWith("Omega")
                .subscribe(System.out::println);
        System.out.println();

        Observable<String> observable = Observable.just("TA", "DK", "SF");
        Observable.just("Weaver", "Troll", "Doom")
                .startWith(observable)
                .startWith(List.of("Zeus", "Night Stalker"))
                .startWithArray("1", "2")
                .subscribe(System.out::println);
    }
}
