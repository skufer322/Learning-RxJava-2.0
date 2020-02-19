package chapter_3.chapter_3_6_ActionOperators;

import io.reactivex.Observable;

public class CH3_6_04_DoOnError {

    public static void main(String[] args) {
        Observable.just(10, 3, 4, 1, 0, 12, 7, 11)
                .doOnError(e -> System.out.println("Source failed!"))
                .map(i -> 10 / i)
                .doOnError((Throwable e) -> System.out.println("Mapping failed!"))
                .subscribe(System.out::println, Throwable::printStackTrace);
    }
}
