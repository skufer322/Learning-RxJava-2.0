package chapter_02;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class CH2_03_Observable_FromIterable {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        Observable.fromIterable(list).subscribe(System.out::println);
    }
}
