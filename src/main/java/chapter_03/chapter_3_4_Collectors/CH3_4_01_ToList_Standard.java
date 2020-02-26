package chapter_03.chapter_3_4_Collectors;

import io.reactivex.Observable;

public class CH3_4_01_ToList_Standard {

    public static void main(String[] args){
        Observable.just("Alpha", "Beta", "Gamma")
                .toList()
                .subscribe(list -> System.out.println("list: " + list));
    }
}
