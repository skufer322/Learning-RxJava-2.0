package chapter_3.chapter_3_4_Collectors;

import com.google.common.collect.ImmutableList;
import io.reactivex.Observable;

public class CH3_4_07_Collect_ToGuavaImmutableList {

    public static void main(String[] args){
        Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Eta", "Theta", "Iota", "Kappa");

        observable.collect(ImmutableList::builder, ImmutableList.Builder::add)
                .map(ImmutableList.Builder::build)
                .subscribe(immutableList -> System.out.println("immutable list: " + immutableList));
    }
}
