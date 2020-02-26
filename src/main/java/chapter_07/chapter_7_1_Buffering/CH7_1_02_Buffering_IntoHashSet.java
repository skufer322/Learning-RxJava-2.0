package chapter_07.chapter_7_1_Buffering;

import io.reactivex.Observable;

import java.util.HashSet;

public class CH7_1_02_Buffering_IntoHashSet {

    public static void main(String[] args){
        Observable.range(1, 50)
                .buffer(12, HashSet::new)
                .subscribe(set -> System.out.println("buffered into hashset: " + set));
    }
}
