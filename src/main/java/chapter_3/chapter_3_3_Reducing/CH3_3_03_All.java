package chapter_3.chapter_3_3_Reducing;

import io.reactivex.Observable;

public class CH3_3_03_All {

    public static void main(String[] args){
        Observable.range(10, 6)
                .all(val -> val < 15)
                .subscribe(bool -> System.out.println("all emissions fulfill predicate: " + bool));

        Observable.range(10, 5)
                .all(val -> val < 15)
                .subscribe(bool -> System.out.println("all emissions fulfill predicate: " + bool));
    }
}
