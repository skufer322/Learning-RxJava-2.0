package chapter_09.chapter_9_1_Transformers;

import com.google.common.collect.ImmutableList;
import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;

public class CH9_1_02_ObservableTransformer_Transformer {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta")
                .compose(toImmutableList())
                .subscribe(list -> System.out.println("Immutable List: " + list));

        Observable.range(1, 10)
                .compose(toImmutableList())
                .subscribe(list -> System.out.println("Immutable List: " + list));

    }

    private static <T> ObservableTransformer<T, ImmutableList<T>> toImmutableList() {
        return upstream ->
                upstream.collect(ImmutableList::<T>builder, ImmutableList.Builder::add)
                        .map(ImmutableList.Builder::build)
                        .toObservable();
    }
}
