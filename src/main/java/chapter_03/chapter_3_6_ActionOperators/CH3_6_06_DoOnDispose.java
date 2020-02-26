package chapter_03.chapter_3_6_ActionOperators;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class CH3_6_06_DoOnDispose {

    public static void main(String[] args) {
        Disposable disposable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .doOnSubscribe(d -> System.out.println("Subscribing!"))
                .doOnDispose(() -> System.out.println("Disposing!")) // funktioniert in diesem Beispiel nicht -> doFinally verwenden
                .doFinally(() -> System.out.println("Finally disposing!"))
                .subscribe(System.out::println);

        System.out.println(disposable.isDisposed());
        disposable.dispose();
        System.out.println(disposable.isDisposed());
    }
}
