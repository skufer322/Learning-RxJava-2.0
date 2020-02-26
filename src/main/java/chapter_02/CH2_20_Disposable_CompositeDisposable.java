package chapter_02;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class CH2_20_Disposable_CompositeDisposable {

    public static void main(String[] args) {
        ConnectableObservable<Long> observable = Observable.interval(1, TimeUnit.SECONDS).publish();
        observable.connect();

        CompositeDisposable compositeDisposable = new CompositeDisposable();

        Disposable disposable1 = observable.subscribe(s -> System.out.println("observer_1 received: " + s));
        sleep(2);
        Disposable disposable2 = observable.subscribe(s -> System.out.println("observer_2 received: " + s));
        sleep(1);
        Disposable disposable3 = observable.subscribe(s -> System.out.println("observer_3 received: " + s));
        sleep(3);

        compositeDisposable.addAll(disposable1, disposable2, disposable3);
        compositeDisposable.dispose();
        System.out.println("Disposed all Observers!");

        sleep(4);
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
