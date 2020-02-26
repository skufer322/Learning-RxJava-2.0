package chapter_02;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class CH2_06_Observable_HotCold_ConnectableObservable {

    public static void main(String[] args) {
        Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        observable.subscribe(s -> System.out.println("observer 1 received: " + s));
        System.out.println();
        observable.subscribe(s -> System.out.println("observer 2 received: " + s));
        System.out.println();

        ConnectableObservable<String> connectableObservable = observable.publish();
        connectableObservable.subscribe(s -> System.out.println("observer 3 received: " + s));
        System.out.println();
        connectableObservable.map(String::length).subscribe(s -> System.out.println("observer 4 received: " + s));
        connectableObservable.connect();
    }


}
