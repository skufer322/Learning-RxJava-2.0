package chapter_2;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observers.ResourceObserver;

/**
 * Beispiel funktioniert so wie im Buch dargestellt nicht so recht!?
 */
public class CH2_21_Disposable_HandleCreate {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.create(observableEmitter -> {
            try {
                for (int i = 0; i < 1_000; i++) {
                    while (!observableEmitter.isDisposed()) {
                        observableEmitter.onNext(i);
                    }

                    if (observableEmitter.isDisposed()) {
                        return;
                    }
                }
                observableEmitter.onComplete();
            } catch (Throwable e) {
                observableEmitter.onError(e);
            }
        });
        ConnectableObservable<Integer> connectableObservable = observable.publish();
        ResourceObserver<Integer> resourceObserver = getResourceObserver();

        Disposable disposable = connectableObservable.subscribeWith(resourceObserver);
        connectableObservable.connect();
    }


    private static ResourceObserver<Integer> getResourceObserver() {
        return new ResourceObserver<Integer>() {

            private int count;

            @Override
            public void onNext(Integer integer) {
                System.out.println("Received: " + integer + " (" + count + ")");
                count++;

                if (count >= 1_000) {
                    this.dispose();
                }
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error Occured: " + throwable);
            }

            @Override
            public void onComplete() {
                System.out.println("completed!");
            }
        };
    }
}
