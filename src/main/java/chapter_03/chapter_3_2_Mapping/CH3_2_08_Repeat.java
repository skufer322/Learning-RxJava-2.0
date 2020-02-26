package chapter_03.chapter_3_2_Mapping;

import io.reactivex.Observable;

public class CH3_2_08_Repeat {

    public static void main(String[] args){
        // Achtung: repeat() wiederholt unendlich oft!
//        Observable.just("Alpha", "Beta", "Gamma")
//                .repeat()
//                .subscribe(System.out::println);

        System.out.println();

        Observable.just("Alpha", "Beta", "Gamma")
                .repeat(3)
                .subscribe(System.out::println);
    }
}
