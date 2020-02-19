package chapter_3.chapter_3_2_Mapping;

import io.reactivex.Observable;

public class CH3_2_04_DefaultIfEmpty {

    public static void main(String[] args){
        Observable.just("Alpha")
                .defaultIfEmpty("Omega")
                .subscribe(System.out::println);

        Observable.empty()
                .defaultIfEmpty("Iota")
                .subscribe(System.out::println);
    }
}
