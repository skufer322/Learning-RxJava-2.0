package chapter_1;

import io.reactivex.Observable;

public class ObservableTryOut_1_Just {

    public static void main(String[] args){
        Observable<String> sourceObservable = Observable.just("Alpha",
                "Beta",
                "Gamma",
                "Delta",
                "Epsilon",
                "Zeta",
                "Eta",
                "Theta",
                "Iota",
                "Kappa");

        sourceObservable.subscribe(s -> System.out.println("RECEIVED: " + s));
    }
}
