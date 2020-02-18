package chapter_2;

import io.reactivex.Observable;

public class CH2_11_Observable_Error {

    public static void main(String[] args) {
        Observable<String> observable = Observable.error(() -> new RuntimeException("Something went wrong!"));

        observable.subscribe(s -> System.out.println("received: " + s), e -> System.out.println("Error Captured: " + e), () -> System.out.println("done"));
    }
}
