package chapter_4.chapter_4_6_GroupBy;

import io.reactivex.Observable;

public class CH4_6_01_GroupBy_ToList {

    public static void main(String[] args){
        Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        // flatmap single sorgt dafür, dass die gruppen erhalten bleiben
        observable.groupBy(String::length)
                .flatMapSingle(grp -> grp.toList())
                .subscribe(System.out::println);

        System.out.println();

        // flatmap zum vergleich -> klopft alles flach in eine 'liste'
        observable.groupBy(String::length)
                .flatMap(s -> s)
                .subscribe(System.out::println);
    }
}
