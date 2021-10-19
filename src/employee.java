import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

public class employee extends Application{
    @Override
    public void start(Stage mainStage) throws Exception
    {
        StackPane main_layout=new StackPane();
        HBox option_bar=new HBox();
        Button manage_view=new Button("view stock");
        Button manage_add=new Button("Add sales");
        option_bar.getChildren().addAll(manage_view,manage_add);
        option_bar.setSpacing(5);
        Scene sc=new Scene(main_layout,400, 500);
        main_layout.getChildren().add(option_bar);
        mainStage.setScene(sc);
        mainStage.show();
    }
}
