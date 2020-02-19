package chapter_3.chapter_3_5_ErrorRecovery;

import io.reactivex.Observable;

public class CH3_5_06_Retry {

    public static void main(String[] args) {
        Observable.just(5, 4, 2, 1, 7, 0, 12, 3, 2)
                .map(i -> 10 / i)
                .retry(1)
                .subscribe(val -> System.out.println("received: " + val), Throwable::printStackTrace);
    }
}
