package chapter_5.chapter_5_4_Subject;

import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

public class CH5_4_05_BehaviorSubject {

    public static void main(String[] args) {

        Subject<String> behaviorSubject = BehaviorSubject.create();

        behaviorSubject.onNext("Alpha");
        behaviorSubject.onNext("Beta");
        behaviorSubject.onNext("Gamma");
        behaviorSubject.onComplete();

        behaviorSubject.subscribe(s -> System.out.println("Observer 2: " + s));
    }
}
