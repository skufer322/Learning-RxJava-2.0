package chapter_10.chapter_10_4_TestScheduler;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.TestScheduler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class CH10_4_02_ReplaceSchedulerTest {

    private CH10_4_02_TestClass_ReplaceScheduler underTest = new CH10_4_02_TestClass_ReplaceScheduler();
    private TestScheduler testScheduler = new TestScheduler();

    @BeforeEach
    void setup() {
        // TODO: ein-/auskommentieren, um Effekte des Ersetzens zu sehen
        // ACHTUNG: Mischung aus echten Schedulern/TestSchedulern vermeiden -> möglichst alle Scheduler durch TestScheduler ersetzen
        // wenn Mischung "echt"/TestScheduler -> wenn der triggernde Scheduler "echt" & weitere Scheduler = TestScheduler -> Programm bleibt hängen
        RxJavaPlugins.setComputationSchedulerHandler(ignore -> testScheduler);
        RxJavaPlugins.setIoSchedulerHandler(ignore -> testScheduler);
    }

    @Test
    void test_TestScheduler_doSth_SameThreadAsInput() {
        System.out.println("TEST: doSth_SameThreadAsInput");
        TestObserver<String> testObserver = new TestObserver<>();

        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS)
                .take(5);
        Observable<String> mappedObservable = underTest.doSth_SameThreadAsInput(observable);
        mappedObservable.doOnNext(str -> System.out.println(str + " on thread " + Thread.currentThread().getName()))
                .subscribe(testObserver);

        testScheduler.advanceTimeBy(10, TimeUnit.SECONDS);

        testObserver.awaitTerminalEvent();
        testObserver.assertValueCount(5);
    }

    @Test
    void test_TestScheduler_doSth_Parallelize() {
        System.out.println("TEST: doSth_Parallelize");
        TestObserver<String> testObserver = new TestObserver<>();

        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS)
                .take(5);
        Observable<String> mappedObservable = underTest.doSth_Parallelize(observable);
        mappedObservable.doOnNext(str -> System.out.println(str + " on thread " + Thread.currentThread().getName()))
                .subscribe(testObserver);

        testScheduler.advanceTimeBy(10, TimeUnit.SECONDS);

        testObserver.awaitTerminalEvent();
        testObserver.assertValueCount(5);
    }

    @Test
    void test_TestScheduler_doSth_Parallelize_IntenseCalculation() {
        System.out.println("TEST: doSth_Parallelize_IntenseCalculation");
        TestObserver<String> testObserver = new TestObserver<>();

        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS)
                .take(5);
        Observable<String> mappedObservable = underTest.doSth_Parallelize_IntenseCalculation(observable);
        mappedObservable.doOnNext(str -> System.out.println(str + " on thread " + Thread.currentThread().getName()))
                .subscribe(testObserver);

        testScheduler.advanceTimeBy(10, TimeUnit.SECONDS);

        testObserver.awaitTerminalEvent();
        testObserver.assertValueCount(5);
    }

    @Test
    void test_TestScheduler_doSth_SecondIntervalThread() {
        System.out.println("TEST: doSth_SecondIntervalThread");
        TestObserver<Long> testObserver = new TestObserver<>();

        Observable<Long> input = Observable.interval(1, TimeUnit.SECONDS)
                .take(5);
        Observable<Long> mapped = underTest.doSth_SecondIntervalThread(input);
        final AtomicInteger counter = new AtomicInteger(0);
        mapped.doOnNext(l -> System.out.println(counter.getAndIncrement() + ": " + l + " on thread " + Thread.currentThread().getName()))
                .subscribe(testObserver);

        testScheduler.advanceTimeBy(10, TimeUnit.SECONDS);

        testObserver.awaitTerminalEvent();
        testObserver.assertValueCount(5);
    }
}