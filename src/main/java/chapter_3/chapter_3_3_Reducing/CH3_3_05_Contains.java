package chapter_3.chapter_3_3_Reducing;

import io.reactivex.Observable;

public class CH3_3_05_Contains {

    public static void main(String[] args){
        Observable.just("Alpha", "Beta", "Gamma")
                .contains("Beta")
                .subscribe(bool -> System.out.println("emissions contain 'Beta': " + bool));
    }
}
