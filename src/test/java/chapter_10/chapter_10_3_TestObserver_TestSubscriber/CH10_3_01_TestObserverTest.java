package chapter_10.chapter_10_3_TestObserver_TestSubscriber;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

class CH10_3_01_TestObserverTest {

    @Test
    void test_testObserver() {
        // Observable und TestObserver aufsetzen
        Observable<String> observable = Observable.just("Alpha", "Beta", "Gamma", "Delta");
        TestObserver<String> testObserver = new TestObserver<>();

        testObserver.assertNotSubscribed();

        // TestObserver auf dem Observable subscriben lassen
        observable.subscribe(testObserver);
        testObserver.assertSubscribed();

        // OnComplete bzw. OnError abwarten
        testObserver.awaitTerminalEvent();

        testObserver.assertComplete();

        testObserver.assertNoErrors();

        testObserver.assertValueCount(4);

        testObserver.assertValues("Alpha", "Beta", "Gamma", "Delta");
    }

    @Test
    void test_testObserver_assertValuesOnly() throws InterruptedException {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS)
                .doOnNext(l -> System.out.println("Emitting " + l));
        TestObserver<Long> testObserver = new TestObserver<>();

        observable.subscribe(testObserver);

        // wait some time
        testObserver.await(4_100, TimeUnit.MILLISECONDS);

        testObserver.assertValuesOnly(0L, 1L, 2L, 3L);
    }

}