package chapter_10.chapter_10_2_BlockingOperations;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class CH10_2_07_BlockingLatestTest {

    @Test
    void test_blockingLatest(){
        Iterable<Long> vals = Observable.interval(1, TimeUnit.MICROSECONDS)
                .take(1_000)
                .blockingLatest();

        for (Long val : vals){
            System.out.println(val);
        }
    }
}
