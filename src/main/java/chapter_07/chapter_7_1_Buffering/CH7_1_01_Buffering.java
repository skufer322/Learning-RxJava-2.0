package chapter_07.chapter_7_1_Buffering;

import io.reactivex.Observable;

public class CH7_1_01_Buffering {

    public static void main(String[] args) {
        Observable.range(1, 10)
                .buffer(3)
                .subscribe(list -> System.out.println("buffered: " + list));

        System.out.println();

        Observable.range(1, 10)
                .buffer(3)
                .filter(list -> list.size() == 3)
                .subscribe(list -> System.out.println("buffered: " + list));
    }

}
