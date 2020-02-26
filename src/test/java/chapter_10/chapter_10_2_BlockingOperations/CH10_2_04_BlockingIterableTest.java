package chapter_10.chapter_10_2_BlockingOperations;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CH10_2_04_BlockingIterableTest {

    @Test
    void test_blockingIterable() {
        Iterable<String> emittedValues = Observable.just("Alpha", "Beta", "Gamma", "Zeta", "Iota")
                .filter(s -> s.length() == 4)
                .blockingIterable();

        for (String emittedValue : emittedValues) {
            assertEquals(4, emittedValue.length());
        }
    }
}
