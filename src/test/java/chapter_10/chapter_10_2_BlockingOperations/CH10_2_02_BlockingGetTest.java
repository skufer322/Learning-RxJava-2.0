package chapter_10.chapter_10_2_BlockingOperations;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class CH10_2_02_BlockingGetTest {

    @Test
    void test_blockingGet(){
        Long sumOfEmittedValues = Observable.interval(1, TimeUnit.SECONDS)
                .take(5)
                .doOnNext(i -> System.out.println("Emitting " + i))
                .reduce(0L, (accumulator, next) -> accumulator + next)
                .blockingGet();

        assertEquals(10, sumOfEmittedValues);
    }

}