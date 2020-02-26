package chapter_10.chapter_10_2_BlockingOperations;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class CH10_2_03_BlockingLastTest {

    @Test
    void test_blockingLast(){
        Long lastValue = Observable.interval(1, TimeUnit.SECONDS)
                .take(5)
                .doOnNext(i -> System.out.println("Emitting " + i))
                .blockingLast(); // blockiert den main-Thread, bis der letzte Wert emittiert wurde

        assertEquals(4, lastValue);
    }

}