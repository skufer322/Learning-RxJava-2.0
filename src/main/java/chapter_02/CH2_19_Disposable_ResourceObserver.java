package chapter_02;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observers.ResourceObserver;

import java.util.concurrent.TimeUnit;

public class CH2_19_Disposable_ResourceObserver {

    public static void main(String[] args) {
        ConnectableObservable<Long> observable = Observable.interval(1, TimeUnit.SECONDS).publish();
        observable.connect();

        Observer<Long> observer = getObserver();
        observable.subscribe(observer); // hier wird kein Disposable zurückgegeben, da eine Observer-Instanz übergeben wird
        // -> RXJava geht davon aus, dass man sich selbst ums Disposen kümmert

        sleep(2);

        ResourceObserver<Long> resourceObserver = getResourceObserver();
        Disposable disposable = observable.subscribeWith(resourceObserver);

        sleep(3);

        disposable.dispose();

        sleep(3);
    }

    private static Observer<Long> getObserver() {
        return new Observer<>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                // do nothing
            }

            @Override
            public void onNext(Long aLong) {
                System.out.println("Received observer: \t\t\t" + aLong);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error Captured observer: " + throwable);
            }

            @Override
            public void onComplete() {
                System.out.println("I'm done observer!");
            }
        };
    }

    private static ResourceObserver<Long> getResourceObserver() {
        return new ResourceObserver<Long>() {
            @Override
            public void onNext(Long aLong) {
                System.out.println("Received resourceObserver: \t" + aLong);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error Captured resourceObserver: " + throwable);
            }

            @Override
            public void onComplete() {
                System.out.println("I'm done resourceObserver!");
            }
        };
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
