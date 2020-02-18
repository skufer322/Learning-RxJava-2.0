package chapter_2;

import io.reactivex.Observable;

public class CH2_07_Observable_Range {

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.range(10, 5);

        observable.subscribe(val -> System.out.println("Received val: " + val));

        Observable<Long> observable1 = Observable.rangeLong((long) Integer.MAX_VALUE + 10, 5);
        observable1.subscribe(val -> System.out.println("Received long: " + val));
    }
}
