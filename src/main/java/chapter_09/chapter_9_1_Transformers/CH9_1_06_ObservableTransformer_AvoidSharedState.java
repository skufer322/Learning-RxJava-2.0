package chapter_09.chapter_9_1_Transformers;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;

import java.util.concurrent.atomic.AtomicInteger;

public class CH9_1_06_ObservableTransformer_AvoidSharedState {

    public static void main(String[] args) {
        Observable<IndexedValue<String>> observable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .compose(withIndex());

        observable.subscribe(s -> System.out.println("Observer 1: " + s));
        observable.subscribe(s -> System.out.println("Observer 2: " + s));
    }

    private static <T> ObservableTransformer<T, IndexedValue<T>> withIndex() {
        return upstream -> Observable.defer(() -> {
            AtomicInteger index = new AtomicInteger(-1);
            return upstream.map(value -> new IndexedValue<>(index.incrementAndGet(), value));
        });
    }

    private static <T> ObservableTransformer<T, IndexedValue<T>> withIndex2() {

        return new ObservableTransformer<T, IndexedValue<T>>() {

            @Override
            public ObservableSource<IndexedValue<T>> apply(Observable<T> observable) {
                return Observable.defer(() -> {
                    final AtomicInteger index = new AtomicInteger(-1);
                    return observable.map(value -> new IndexedValue<>(index.incrementAndGet(), value));
                });
            }
        };
    }

    private static final class IndexedValue<T> {

        private int index;
        private T value;

        public IndexedValue(int index, T value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public String toString() {
            return index + " - " + value;
        }
    }
}
