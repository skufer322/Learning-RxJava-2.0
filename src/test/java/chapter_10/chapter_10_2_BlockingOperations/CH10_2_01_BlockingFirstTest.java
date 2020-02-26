package chapter_10.chapter_10_2_BlockingOperations;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class CH10_2_01_BlockingFirstTest {

    @Test
    void test_blockingFirst(){
        Long firstValue = Observable.interval(1, TimeUnit.SECONDS)
                .take(5)
                .doOnNext(i -> System.out.println("Emitting " + i))
                .blockingFirst(); // blockiert den main-Thread, bis der erste Wert emittiert wurde

        assertEquals(0, firstValue);
    }

}