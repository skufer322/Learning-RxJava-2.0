package chapter_09.chapter_9_1_Transformers;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;

public class CH9_1_03_ObservableTransformer_TypedTransformerWithParameter {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta")
                .compose(joinWithSeparatorReduce("/"))
                .subscribe(System.out::println);

        Observable.just("Alpha", "Beta", "Gamma", "Delta")
                .compose(joinWithSeparatorStringBuilder(":"))
                .subscribe(System.out::println);
    }

    private static ObservableTransformer<String, String> joinWithSeparatorReduce(String separator) {
        return upstream ->
                upstream.reduce("", (accumulator, next) -> accumulator.equals("") ? next : accumulator + separator + next)
                        .toObservable();
    }

    private static ObservableTransformer<String, String> joinWithSeparatorStringBuilder(String separator) {
        return upstream ->
                upstream.collect(StringBuilder::new,
                        (builder, string) -> {
                            if (builder.length() == 0) {
                                builder.append(string);
                            } else {
                                builder.append(separator).append(string);
                            }
                        })
                        .map(StringBuilder::toString)
                        .toObservable();
    }
}
