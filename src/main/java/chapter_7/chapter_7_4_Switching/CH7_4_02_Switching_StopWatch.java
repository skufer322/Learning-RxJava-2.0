//package chapter_7.chapter_7_4_Switching;
//
//import io.reactivex.Observable;
//import io.reactivex.Observer;
//import io.reactivex.rxjavafx.observables.JavaFxObservable;
//import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.control.ToggleButton;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//import java.util.concurrent.TimeUnit;
//
//public class CH7_4_02_Switching_StopWatch extends Application {
//
//braucht Java 8 -> in POM und IntelliJ Settings umstellen!
//
//    @Override
//    public void start(Stage stage) throws Exception {
//        VBox root = new VBox();
//        Label counterLabel = new Label("");
//        ToggleButton startStopButton = new ToggleButton();
//
//        Observable<Boolean> selectedStates = JavaFxObservable.valuesOf(startStopButton.selectedProperty())
//                .publish()
//                .autoConnect(2);
//
//        selectedStates.switchMap(selected ->
//                selected ? Observable.interval(1, TimeUnit.MILLISECONDS) : Observable.empty())
//                .observeOn(JavaFxScheduler.platform())
//                .subscribe(l -> counterLabel.setText(l + " ms"));
//
//        selectedStates
//                .map(selected -> selected ? "STOP" : "START")
//                .subscribe(startStopButton::setText);
//
//        root.getChildren().addAll(counterLabel, startStopButton);
//        stage.setScene(new Scene(root));
//        stage.show();
//    }
//}
