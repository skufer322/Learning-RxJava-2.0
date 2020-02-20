package chapter_5.chapter_5_4_Subject;

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class CH5_4_03_Subject_GoneWrong {

    public static void main(String[] args) {
        Subject<String> subject = PublishSubject.create();

        subject.onNext("Alpha");
        subject.onNext("Beta");
        subject.onComplete();

        // nichts passiert, weil bei Übergabe der Strings noch kein Observer spezifiziert wurde
        subject.map(String::toUpperCase).subscribe(System.out::println);
    }
}
