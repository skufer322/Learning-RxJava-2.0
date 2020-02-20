package chapter_5.chapter_5_4_Subject;

import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subjects.Subject;

public class CH5_4_06_ReplaySubject {

    public static void main(String[] args){
        Subject<String> subject = ReplaySubject.create();

        subject.onNext("Alpha");
        subject.onNext("Beta");
        subject.onNext("Gamma");
        subject.onComplete();

        subject.subscribe(s -> System.out.println("Observer: " + s));
    }
}
