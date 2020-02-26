package chapter_10.chapter_10_1_BlockingSubscribers;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class CH10_1_01_BlockingSubscribersTest {

    @Test
    void test_notWorking_because_nonBlockingSubscribe(){
        final AtomicInteger count = new AtomicInteger(0);

        Observable.interval(1, TimeUnit.SECONDS)
                .take(5)
                .subscribe(i -> count.incrementAndGet());

        assertEquals(5, count.get());
    }

    @Test
    void test_working_because_blockingSubscribe(){
        final AtomicInteger count = new AtomicInteger(0);

        Observable.interval(1, TimeUnit.SECONDS)
                .take(5)
                .blockingSubscribe(i -> count.incrementAndGet());

        assertEquals(5, count.get());
    }
}
