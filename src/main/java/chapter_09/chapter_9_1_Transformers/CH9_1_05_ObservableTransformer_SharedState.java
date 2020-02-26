package chapter_09.chapter_9_1_Transformers;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;

import java.util.concurrent.atomic.AtomicInteger;

public class CH9_1_05_ObservableTransformer_SharedState {

    public static void main(String[] args) {
        Observable<IndexedValue<String>> observable = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .compose(withIndex());

        observable.subscribe(s -> System.out.println("Observer 1: " + s));
        observable.subscribe(s -> System.out.println("Observer 2: " + s));
    }

    private static <T> ObservableTransformer<T, IndexedValue<T>> withIndex() {
        final AtomicInteger index = new AtomicInteger(-1);
        return upstream ->
                upstream.map(value -> new IndexedValue<>(index.incrementAndGet(), value));
    }

    private static <T> ObservableTransformer<T, IndexedValue<T>> withIndex2(){
        return new ObservableTransformer<T, IndexedValue<T>>() {

            private final AtomicInteger index = new AtomicInteger(-1);

            @Override
            public ObservableSource<IndexedValue<T>> apply(Observable<T> observable) {
                return observable.map(value -> new IndexedValue<>(index.incrementAndGet(), value));
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
