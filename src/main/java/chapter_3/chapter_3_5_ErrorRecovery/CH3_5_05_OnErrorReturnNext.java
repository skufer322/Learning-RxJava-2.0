package chapter_3.chapter_3_5_ErrorRecovery;

import io.reactivex.Observable;

public class CH3_5_05_OnErrorReturnNext {

    public static void main(String[] args){
        Observable<Integer> observable = Observable.just(100, 200, 300, 400, 500)
                .map(i -> i / 10);

        Observable.just(5, 4, 2, 1, 7, 0, 12, 3, 2)
                .map(i -> 10 / i)
                .onErrorResumeNext(observable)
                .subscribe(val -> System.out.println("received: " + val), Throwable::printStackTrace);
    }
}
