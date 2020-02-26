package chapter_10.chapter_10_4_TestScheduler;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

class CH10_4_01_TestSchedulerTest {

    @Test
    void test_TestScheduler() {
        TestScheduler testScheduler = new TestScheduler();
        TestObserver<Long> testObserver = new TestObserver<>();

        Observable<Long> observable = Observable.interval(1, TimeUnit.MINUTES, testScheduler)
                .doOnNext(i -> System.out.println((i + 1) + " minutes passed"));
        observable.subscribe(testObserver);

        testScheduler.advanceTimeBy(50, TimeUnit.SECONDS);

        testObserver.assertValueCount(0);

        testScheduler.advanceTimeBy(111, TimeUnit.SECONDS);

        testObserver.assertValueCount(2);

        testScheduler.advanceTimeTo(51, TimeUnit.MINUTES);

        testObserver.assertValueCount(51);

        testScheduler.advanceTimeBy(39, TimeUnit.MINUTES);

        testObserver.assertValueCount(90);
    }

}