package chapter_02;

import io.reactivex.Maybe;
import io.reactivex.Observable;

public class CH2_15_Maybe {

    public static void main(String[] args) {
        Observable<String> nonEmpty = Observable.just("Alpha", "Beta", "Gamma");
        Maybe<String> maybe1 = nonEmpty.firstElement();
        maybe1.subscribe(s -> System.out.println("maybe1 pushed: " + s), Throwable::printStackTrace, () -> System.out.println("done maybe1"));

        System.out.println();

        Observable<String> empty = Observable.empty();
        Maybe<String> maybe2 = empty.firstElement();
        maybe2.subscribe(s -> System.out.println("maybe2 pushed: " + s), Throwable::printStackTrace, () -> System.out.println("done maybe2"));
    }
}
