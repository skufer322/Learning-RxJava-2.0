package chapter_7.chapter_7_4_Switching;

import io.reactivex.Observable;
import io.reactivex.rxjavafx.observables.JavaFxObservable;
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public class CH7_4_03_Switching_Keystrokes extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        root.setMinSize(200, 100);
        Label typedTextLabel = new Label("");
        root.getChildren().add(typedTextLabel);
        Scene scene = new Scene(root);

        Observable<String> typedLetters = JavaFxObservable.eventsOf(scene, KeyEvent.KEY_TYPED)
                .map(KeyEvent::getCharacter)
                .publish()
                .refCount();

        Observable<String> restSignal = typedLetters.throttleWithTimeout(500, TimeUnit.MILLISECONDS)
                .startWith(""); // ist eigentlich unnötig, da man an diesem wert nicht interessiert ist

        restSignal.switchMap(s ->
                typedLetters.scan("", (accumulator, next) -> accumulator + next)
                        .doOnSubscribe(s2 -> System.out.println("Starting new Window")))
                .observeOn(JavaFxScheduler.platform())
                .subscribe(s -> {
                    typedTextLabel.setText(s);
                    System.out.println(s);
                });

        stage.setScene(scene);
        stage.show();
    }
}
