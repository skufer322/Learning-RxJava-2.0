package chapter_2;

import io.reactivex.Observable;

public class ObservableTryOut_2_Create_Exception {

    public static void main(String[] args){
        Observable<Integer> observable = Observable.create(emitter ->
                {
                    try {
                        emitter.onNext(10 / 5);
                        emitter.onNext(10 / 4);
                        emitter.onNext(10 / 3);
                        emitter.onNext(10 / 2);
                        emitter.onNext(10 / 1);
                        emitter.onNext(10 / 0);
                    } catch (Exception e){
                        emitter.onError(e);
                    }
                }
        );

        observable.subscribe(val -> System.out.println("Ergebnis der Division: " + val), Throwable::printStackTrace);
    }
}
