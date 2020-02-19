package chapter_3.chapter_3_4_Collectors;

import io.reactivex.Observable;

import java.util.LinkedList;

public class CH3_4_02_ToList_DifferentListType {

    public static void main(String[] args){
        Observable.just("Alpha", "Beta", "Gamma")
                .toList(LinkedList::new)
                .subscribe(list -> System.out.println("linked list: " + list));
    }
}
