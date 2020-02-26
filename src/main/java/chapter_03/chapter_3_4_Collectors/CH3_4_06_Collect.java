package chapter_03.chapter_3_4_Collectors;

import io.reactivex.Observable;

import java.util.TreeSet;

public class CH3_4_06_Collect {

    public static void main(String[] args) {
        Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Eta", "Theta", "Iota", "Kappa");

        observable.collect(TreeSet<String>::new, TreeSet::add)
                .subscribe(treeSet -> System.out.println("collected observables into treeSet: " + treeSet));
    }
}
