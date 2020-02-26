package chapter_08.chapter_8_2_FlowableAndSubscriber;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class CH8_2_03_FlowableAndSubscriber_SubscriberImpl {

    public static void main(String[] args) {
//        Subscriber<Integer> subscriber = getUnlimitedSubscriber();
        Subscriber<Integer> subscriber = getLimitedSubscriber();

        Flowable.range(1, 150)
                .doOnNext(i -> System.out.println("Flowable pushed " + i))
                .observeOn(Schedulers.io())
                .map(i -> intenseCalculation(i))
                .subscribe(subscriber);

        sleep(20_000);
    }

    private static Subscriber<Integer> getUnlimitedSubscriber() {
        return new Subscriber<>() {

            @Override
            public void onSubscribe(Subscription subscription) {
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer i) {
                sleep(50);
                System.out.println("Unlimited subscriber received " + i);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Done");
            }
        };
    }

    private static Subscriber<Integer> getLimitedSubscriber() {
        return new Subscriber<>() {

            private AtomicInteger counter = new AtomicInteger(0);
            private Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                System.out.println("Requesting 40 items");
                subscription.request(40);
            }

            @Override
            public void onNext(Integer i) {
                sleep(50);
                System.out.println("Limited subscriber received " + i);

                if (counter.incrementAndGet() % 20 == 0 && counter.get() >= 40) {
                    System.out.println("Requesting the next 20 items [" + counter.get() + "]");
                    subscription.request(20);
                }
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Done");
            }
        };
    }

    private static <T> T intenseCalculation(T value) {
        sleep(ThreadLocalRandom.current().nextInt(150));
        return value;
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
