package chapter_02;

import io.reactivex.Completable;

public class CH2_16_Completable {

    public static void main(String[] args) {
        Completable completable = Completable.fromRunnable(CH2_16_Completable::runProcess);
        completable.subscribe(() -> System.out.println("done with Completable"));
    }

    private static void runProcess() {
        sleep(3);
        System.out.println("Hello");
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
