package chapter_2;

import io.reactivex.Observable;

import java.util.List;

public class CH2_03_Observable_FromIterable {

    public static void main(String[] args) {
        List<String> list = List.of("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        Observable.fromIterable(list).subscribe(System.out::println);
    }
}
