package chapter_7.chapter_7_1_Buffering;

import io.reactivex.Observable;

public class CH7_1_03_Buffering_Skip {

    public static void main(String[] args) {
        Observable.range(1, 10)
                .buffer(2, 3)
                .subscribe(System.out::println);

        System.out.println();

        Observable.range(1, 10)
                .buffer(2,1)
                .subscribe(System.out::println);
    }
}
