package chapter_5.chapter_5_4_Subject;

import io.reactivex.Observable;
import io.reactivex.subjects.Subject;
import io.reactivex.subjects.UnicastSubject;

import java.util.concurrent.TimeUnit;

public class CH5_4_08_UnicastSubject {

    public static void main(String[] args){
        Subject<Long> subject = UnicastSubject.create();

        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(subject);

        sleep(10);

        subject.subscribe(l -> System.out.println("received: " + l));

        sleep(5);

        // ein zweiter Subscriber auf dem UnicastSubject sorgt für Exception!
//        subject.subscribe(System.out::println);
//        sleep(2);
    }

    private static void sleep(int seconds){
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
