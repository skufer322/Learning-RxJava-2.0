package chapter_10.chapter_10_2_BlockingOperations;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class CH10_2_06_BlockingNextTest {

    @Test
    void test_blockingNext(){
        Iterable<Long> vals = Observable.interval(1, TimeUnit.MICROSECONDS)
                .take(1_000)
                .blockingNext(); // Emissionen, die zwischen zwei aufeinanderfolgenden next()-Calls des Iterable abgeleiteten Iterators erfolgen, werden ignoriert

        for (Long val : vals){
            System.out.println(val);
        }
    }
}
