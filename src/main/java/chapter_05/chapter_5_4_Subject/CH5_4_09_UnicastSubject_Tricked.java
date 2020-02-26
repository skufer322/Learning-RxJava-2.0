package chapter_05.chapter_5_4_Subject;

import io.reactivex.Observable;
import io.reactivex.subjects.Subject;
import io.reactivex.subjects.UnicastSubject;

import java.util.concurrent.TimeUnit;

public class CH5_4_09_UnicastSubject_Tricked {

    public static void main(String[] args){
        Subject<Long> subject = UnicastSubject.create();

        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(subject);

        sleep(3);

        // hier kommt der Trick
        Observable<Long> multicast = subject.publish().autoConnect();

        multicast.subscribe(l -> System.out.println("Observer 1: " + l));
        sleep(2);
        multicast.subscribe(l -> System.out.println("Observer 2: " + l));
        sleep(3);
    }

    private static void sleep(int seconds){
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
