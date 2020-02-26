package chapter_02;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class CH2_17_Disposable {

    public static void main(String[] args) {
        ConnectableObservable<Long> observable = Observable.interval(1, TimeUnit.SECONDS).publish();

        Disposable disposable1 = observable.subscribe(s -> System.out.println("observer_1: " + s), Throwable::printStackTrace, () -> System.out.println("observer1 is done"));
        observable.connect();
        sleep(3);
        Disposable disposable2 = observable.subscribe(s -> System.out.println("observer_2: " + s), Throwable::printStackTrace, () -> System.out.println("observer1 is done"));
        sleep(2);

        disposable1.dispose();
        sleep(2);
        disposable2.dispose();
        sleep(3);
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
