package chapter_3.chapter_3_2_Mapping;

import io.reactivex.Observable;

public class CH3_2_09_Scan {

    public static void main(String[] args){
        Observable.just(1, 2, 3, 4, 5)
                .scan(Integer::sum)
                .subscribe(val -> System.out.println("accumulated: " + val));

        System.out.println();

        Observable.just(1, 2, 3, 4, 5)
                .scan(20, Integer::sum)
                .subscribe(val -> System.out.println("accumulated: " + val));

        System.out.println();

        Observable.just("Alpha", "Beta", "Gamma")
                .scan("start", (accumulator, next) -> String.join(":", accumulator, next))
                .skip(1)
                .subscribe(System.out::println);
    }
}
