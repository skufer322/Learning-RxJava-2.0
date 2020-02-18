package chapter_1;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class CH1_2_Observable_Just_Map_Filter {

    public static void main(String[] args){
        Disposable x = Observable.just(1, 2, 3, 4, 5, 6, 7)
                .map(val -> val * 3)
                .filter(val -> val < 15)
                .subscribe(s -> System.out.println("RECEIVED AFTER MAP AND FILTER:\t" + s));

        System.out.println(x.toString());
    }
}
