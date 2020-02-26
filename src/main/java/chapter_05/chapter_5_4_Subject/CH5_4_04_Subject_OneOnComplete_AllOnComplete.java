package chapter_05.chapter_5_4_Subject;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

import java.util.concurrent.TimeUnit;

public class CH5_4_04_Subject_OneOnComplete_AllOnComplete {

    public static void main(String[] args) {
        Observable<String> observable1 = Observable.interval(1, TimeUnit.SECONDS)
                .map(i -> "Observer 1: " + (i + 1) + " seconds passed")
                .take(7);
        Observable<String> observable2 = Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(i -> "Observer 2: " + ((i + 1) * 300) + " milliseconds passed");

        Subject<String> subject = PublishSubject.create();

        subject.subscribe(s -> System.out.println("serialized: " + s));

        observable1.subscribe(subject); // sobald eine Source onComplete() aufruft, emittiert Subject auch nichts mehr!
        observable2.subscribe(subject);

        sleep(10);
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
