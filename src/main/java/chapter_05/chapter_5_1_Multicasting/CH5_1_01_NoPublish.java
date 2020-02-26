package chapter_05.chapter_5_1_Multicasting;

import io.reactivex.Observable;

import java.util.concurrent.ThreadLocalRandom;

public class CH5_1_01_NoPublish {

    public static void main(String[] args){
        Observable<Integer> observable = Observable.range(1, 3)
                .map(i -> nextRandom());

        observable.subscribe(i -> System.out.println("Observer 1: " + i));
        observable.subscribe(i -> System.out.println("Observer 2: " + i));
    }

    private static int nextRandom(){
        return ThreadLocalRandom.current().nextInt(1_000);
    }
}
