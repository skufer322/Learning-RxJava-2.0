package chapter_08.chapter_8_1_Flowable;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class CH8_1_Flowable {

    public static void main(String[] args) {
        Flowable.range(1, 1_000)
                .map(MyItem::new)
                .observeOn(Schedulers.io())
                .subscribe(item ->
                {
                    sleep(50);
                    System.out.println("Received MyItem " + item.toString());
                });

        sleep(10_000);
    }

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class MyItem {

        private int value;

        public MyItem(int i) {
            this.value = i;
            System.out.println("Constructing MyItem " + this.value);
        }

        public String toString() {
            return "" + this.value;
        }
    }
}
