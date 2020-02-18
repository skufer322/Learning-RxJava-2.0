package chapter_2;

import io.reactivex.Observable;

public class CH2_05_Observer_SubscribeÜberladeneMethoden {

    public static void main(String[] args) {
        Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        observable.subscribe(s -> System.out.println("received: " + s));
        System.out.println();
        observable.subscribe(s -> System.out.println("erhalten:" + s), Throwable::printStackTrace);
        System.out.println();
        observable.subscribe(s -> System.out.println("bekommen:" + s), Throwable::printStackTrace, () -> System.out.println("erledigt:\t" + observable.toString()));
    }
}
