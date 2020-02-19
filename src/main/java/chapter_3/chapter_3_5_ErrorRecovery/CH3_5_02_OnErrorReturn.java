package chapter_3.chapter_3_5_ErrorRecovery;

import io.reactivex.Observable;

public class CH3_5_02_OnErrorReturn {

    public static void main(String[] args){
        Observable.just(5, 4, 2, 1, 7, 0, 12, 3, 2)
                .map(i -> 10 / i)
                .onErrorReturn((Throwable e) -> -1) // hier könnte man dann auf e zugreifen und abhängig vom Fehler dynamisch Werte erzeugen..?
                .subscribe(val -> System.out.println("received: " + val), Throwable::printStackTrace, () -> System.out.println("done"));
    }
}
