package chapter_3.chapter_3_4_Collectors;

import io.reactivex.Observable;

import java.util.Comparator;

public class CH3_4_03_ToSortedList {

    public static void main(String[] args){
        Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Eta", "Theta", "Iota", "Kappa");

        observable.toSortedList()
                .subscribe(list -> System.out.println("sorted list: " + list));

        observable.toSortedList(Comparator.reverseOrder())
                .subscribe(list -> System.out.println("reversely sorted list: " + list));

        observable.toSortedList(Comparator.comparingInt(String::length))
                .subscribe(list -> System.out.println("sorted by string length: " + list));
    }
}
