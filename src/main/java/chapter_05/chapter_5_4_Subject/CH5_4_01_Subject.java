package chapter_05.chapter_5_4_Subject;

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class CH5_4_01_Subject {

    public static void main(String[] args) {

        Subject<String> subject = PublishSubject.create();

        subject.map(String::toUpperCase)
                .subscribe(s -> System.out.println("first mapping: " + s));

        subject.onNext("Alpha");
        subject.onNext("Beta");
        subject.map(String::toLowerCase).subscribe(s -> System.out.println("second mapping: " + s));
        subject.map(String::length).subscribe(s -> System.out.println("third mapping: " + s));
        subject.onNext("Gamma");
        subject.onComplete();
    }
}
