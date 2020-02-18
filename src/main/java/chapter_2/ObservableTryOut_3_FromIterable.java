package chapter_2;

import io.reactivex.Observable;

import java.util.List;

public class ObservableTryOut_3_FromIterable {

    public static void main(String[] args){
        List<String> list = List.of("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        Observable.fromIterable(list).subscribe(System.out::println);
    }
}
