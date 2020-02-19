package chapter_3.chapter_3_3_Reducing;

import io.reactivex.Observable;

public class CH3_3_01_Count {

    public static void main(String[] args){
        Observable.just(1, 2, 3, 4, 5)
                .count()
                .subscribe(val -> System.out.println("count: " + val));
    }
}
