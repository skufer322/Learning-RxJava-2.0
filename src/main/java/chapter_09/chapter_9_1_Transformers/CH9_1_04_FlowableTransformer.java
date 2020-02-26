package chapter_09.chapter_9_1_Transformers;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;

public class CH9_1_04_FlowableTransformer {

    public static void main(String[] args) {
        Flowable.just("Alpha", "Beta", "Gamma", "Delta")
                .compose(joinWithSeparatorReduce("-"))
                .subscribe(System.out::println);
    }

    private static FlowableTransformer<String, String> joinWithSeparatorReduce(String separator) {
        return upstream ->
                upstream.reduce("", (accumulator, next) -> accumulator.equals("") ? next : accumulator + separator + next)
                        .toFlowable();
    }
}
