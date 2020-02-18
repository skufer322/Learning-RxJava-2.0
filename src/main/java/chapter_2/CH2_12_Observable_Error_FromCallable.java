package chapter_2;

import io.reactivex.Observable;

public class CH2_12_Observable_Error_FromCallable {

    public static void main(String[] args) {
        // ein-/auskommentieren
//        Observable<Integer> observable = Observable.just(1/0);
//        observable.subscribe(val -> System.out.println("received: " + val), e -> System.out.println("Error Captured: " + e), () -> System.out.println("done"));

        Observable<Integer> observable2 = Observable.fromCallable(() -> 1 / 0);
        observable2.subscribe(System.out::println, e -> System.out.println("Error Captured: " + e), () -> System.out.println("done"));
    }
}
