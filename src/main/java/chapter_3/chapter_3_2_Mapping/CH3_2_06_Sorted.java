package chapter_3.chapter_3_2_Mapping;

import io.reactivex.Observable;

public class CH3_2_06_Sorted {

    public static void main(String[] args){
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Iota")
            .sorted( (item1, item2) -> {return -1 * Integer.compare(item1.length(), item2.length());})
            .subscribe(System.out::println);
    }
}
