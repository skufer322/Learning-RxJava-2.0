package chapter_10.chapter_10_2_BlockingOperations;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class CH10_2_08_BlockingMostRecentTest {

    @Test
    void test_blockingMostRecent(){
        Iterable<Long> values = Observable.interval(1_000, TimeUnit.MICROSECONDS)
                .take(5)
                .blockingMostRecent(-1L);

        for (Long val : values){
            System.out.println(val);
        }
    }
}
