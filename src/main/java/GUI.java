import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application{

    public void start(Stage primaryStage) throws Exception {
       VBox parent = new VBox();
       parent.getChildren().add(new Label("Wiki"));

       HBox wikiURL = new HBox(new Label("URL: "));
       TextField textField = new TextField();
       wikiURL.getChildren().add(textField);
       parent.getChildren().add(wikiURL);

       Button button = new Button("Wiki");

       Scene scene = new Scene(new Label("Wiki"));
       primaryStage.setScene(scene);
       primaryStage.show();

    }
}
