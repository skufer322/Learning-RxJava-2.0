package chapter_02;

import io.reactivex.Observable;

public class CH2_13_Observable_Defer {

    private static int start = 1;
    private static int count = 3;

    public static void main(String[] args) {
        Observable<Integer> observable1 = Observable.range(start, count);
        observable1.subscribe(val -> System.out.println("obs_1 received val: " + val));

        count = 2;
        observable1.subscribe(val -> System.out.println("obs_2 received val: " + val));

        System.out.println();
        Observable<Integer> deferredObservable = Observable.defer(() -> Observable.range(start, count));
        deferredObservable.subscribe(val -> System.out.println("obs_3 received val: " + val));
        count = 1;
        deferredObservable.subscribe(val -> System.out.println("obs_4 received val: " + val));
    }
}
