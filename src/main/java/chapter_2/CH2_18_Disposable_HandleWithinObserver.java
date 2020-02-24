package chapter_2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class CH2_18_Disposable_HandleWithinObserver {

    public static void main(String[] args) {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);

        observable.subscribe(new Observer<Long>() {

            private Disposable disposable;
            int counter;

            @Override
            public void onSubscribe(Disposable disposable) {
                this.disposable = disposable;
            }

            @Override
            public void onNext(Long aLong) {
                System.out.println("Received: " + aLong);
                counter++;

                if (counter == 10) {
                    onComplete();
                }
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error Captured: " + throwable);
            }

            @Override
            public void onComplete() {
                disposable.dispose();
                System.out.println("Successfully completed and disposed!");
            }
        });

        sleep(20);
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
