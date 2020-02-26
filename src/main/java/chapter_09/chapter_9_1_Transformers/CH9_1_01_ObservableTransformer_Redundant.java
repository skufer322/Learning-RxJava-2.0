package chapter_09.chapter_9_1_Transformers;

import com.google.common.collect.ImmutableList;
import io.reactivex.Observable;

public class CH9_1_01_ObservableTransformer_Redundant {

    public static void main(String[] args){
        Observable.just("Alpha", "Beta", "Gamma", "Delta")
                .collect(ImmutableList::builder, ImmutableList.Builder::add)
                .map(ImmutableList.Builder::build)
                .subscribe(list -> System.out.println("Immutable List: " + list));

        Observable.range(1, 10)
                .collect(ImmutableList::builder, ImmutableList.Builder::add)
                .map(ImmutableList.Builder::build)
                .subscribe(list -> System.out.println("Immutable List: " + list));
    }
}
