package chapter_03.chapter_3_5_ErrorRecovery;

import io.reactivex.Observable;

public class CH3_5_03_OnErrorReturnNext_GracefulOnComplete {

    public static void main(String[] args){
        Observable.just(5, 4, 2, 1, 7, 0, 12, 3, 2)
                .map(i -> 10 / i)
                .onExceptionResumeNext(Observable.empty())
                .subscribe(val -> System.out.println("received: " + val));
    }
}
