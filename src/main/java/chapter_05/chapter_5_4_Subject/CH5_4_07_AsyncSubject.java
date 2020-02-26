package chapter_05.chapter_5_4_Subject;

import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.Subject;

public class CH5_4_07_AsyncSubject {

    public static void main(String[] args){
        Subject<String> subject = AsyncSubject.create();

        subject.subscribe(s -> System.out.println("Observer 1: " + s), Throwable::printStackTrace, () -> System.out.println("observer1 done!"));

        subject.onNext("Alpha");
        subject.onNext("Beta");
        subject.onNext("Gamma");
        subject.onComplete();

        subject.subscribe(s -> System.out.println("Observer 2: " + s), Throwable::printStackTrace, () -> System.out.println("observer2 done!"));
    }
}
