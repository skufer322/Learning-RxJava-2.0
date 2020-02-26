package chapter_02;

import io.reactivex.Observable;

public class CH2_01_Observable_Create {

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
