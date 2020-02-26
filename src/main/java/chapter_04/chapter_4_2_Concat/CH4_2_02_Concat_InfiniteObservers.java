package chapter_04.chapter_4_2_Concat;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CH4_2_02_Concat_InfiniteObservers {

    public static void main(String[] args){
        Observable<String> observable1 = Observable.interval(1, TimeUnit.SECONDS)
                .map(i -> (i+1) + " seconds passed")
                .take(3, TimeUnit.SECONDS);
        Observable<String> observable2 = Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(i -> ((i+1) * 300) + " milliseconds passed");

        Observable.concat(observable1, observable2)
                .subscribe(System.out::println);
        sleep(10);
    }

    private static void sleep(int seconds){
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
