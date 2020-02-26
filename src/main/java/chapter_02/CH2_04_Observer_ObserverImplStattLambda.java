package chapter_02;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CH2_04_Observer_ObserverImplStattLambda {

    public static void main(String[] args) {
        Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        Observer<String> observer = new Observer<>() {

            @Override
            public void onSubscribe(Disposable disposable) {
                // do nothing
            }

            @Override
            public void onNext(String s) {
                System.out.println("RECEIVED:\t" + s);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("ERROR THROWN:\t" + throwable);
            }

            @Override
            public void onComplete() {
                System.out.println("DONE");
            }
        };

        observable.subscribe(observer);
    }
}
