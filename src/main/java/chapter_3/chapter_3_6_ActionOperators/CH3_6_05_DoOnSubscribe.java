package chapter_3.chapter_3_6_ActionOperators;

import io.reactivex.Observable;

public class CH3_6_05_DoOnSubscribe {

    public static void  main(String[] args){
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .doOnSubscribe(disposable -> System.out.println("Subscribed and received the following disposable: " + disposable.toString()))
                .map(String::toUpperCase)
                .subscribe(System.out::println);
    }
}
