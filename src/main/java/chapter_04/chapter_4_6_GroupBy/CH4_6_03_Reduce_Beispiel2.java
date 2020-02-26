package chapter_04.chapter_4_6_GroupBy;

import io.reactivex.Observable;

public class CH4_6_03_Reduce_Beispiel2 {

    public static void main(String[] args){

        Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma", "Grammophon", "Aioli", "Atos", "Abbadon");

        // wie viele Items gibt es in der jeweiligen Gruppe? gruppiert wird nach dem Anfangsbuchstaben
        observable.groupBy(s -> s.charAt(0))
                .flatMapSingle(grp ->
                                grp.reduce(0, (accumulator, next) -> accumulator + 1)
                        .map(i -> grp.getKey() + ": " + i)
                )
                .subscribe(System.out::println);

    }
}
