package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sysCalcSinglePage.fxml"));
        primaryStage.setTitle("SystemCalc");
        primaryStage.setScene(new Scene(root, 1007, 650));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("icon.gif")));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
