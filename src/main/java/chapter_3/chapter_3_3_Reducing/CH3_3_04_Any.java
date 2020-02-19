package chapter_3.chapter_3_3_Reducing;

import io.reactivex.Observable;

public class CH3_3_04_Any {

    public static void main(String[] args){
        Observable.just(1, 2, 3, 4)
                .any(val -> val > 5)
                .subscribe(bool -> System.out.println("any emission fulfills predicate: " + bool));
    }
}
