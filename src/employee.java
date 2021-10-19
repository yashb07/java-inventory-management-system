import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

public class employee extends Application{
    @Override public void start(Stage mainStage) throws Exception {
        StackPane sp = new StackPane();
        Scene sc = new Scene(sp, 400, 600);
        mainStage.setScene(sc);
        mainStage.setTitle("Employee");
        mainStage.show();
        Label success = new Label("Employee Page");
        sp.getChildren().add(success);
    }
}
