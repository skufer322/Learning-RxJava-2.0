package chapter_10.chapter_10_2_BlockingOperations;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CH10_2_05_BlockingForEachTest {

    @Test
    void test_blockingForEach(){
        Observable.just("Alpha", "Beta", "Gamma", "Zeta", "Iota")
                .doOnNext(s -> System.out.println("Emitted: " + s))
                .filter(s -> s.length() == 4)
                .doOnNext(s -> System.out.println("Passed filter: " + s))
                .blockingForEach(s -> assertEquals(4, s.length()));
    }

}