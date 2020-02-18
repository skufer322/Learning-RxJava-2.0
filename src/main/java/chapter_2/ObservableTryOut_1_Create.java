package chapter_2;

import io.reactivex.Observable;

public class ObservableTryOut_1_Create {

    public static void main(String[] args) {
        Observable<String> sourceObservable = Observable.create(emitter -> {
            emitter.onNext("HELLO");
            emitter.onNext("WORLD");
            emitter.onNext("!");
        });

        System.out.println("Nothing happened yet! Need to subscribe, first!\n");

        sourceObservable.subscribe(System.out::println);
    }
}
