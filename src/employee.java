//VM options --module-path "D:\javafx-sdk-17.0.0.1\lib" --add-modules javafx.controls,javafx.fxml
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class employee extends Application{
    @Override
    public void start(Stage mainStage) throws Exception
    {
        //main layout
        StackPane main_layout=new StackPane();

        //layout as a object for options
        HBox option_bar = new HBox();
        Button manage_view = new Button("Add Sales");
        Button manage_add = new Button("Update Inventory");
        option_bar.getChildren().addAll(manage_view,manage_add);
        option_bar.setSpacing(5);
        //layout as an object for add sales
        manage_view.setOnAction(e->{
            Add_Sales sales = new Add_Sales();
            try {
                sales.start(mainStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        manage_add.setOnAction(e->{
            Update_Inventory_Employee uinv = new Update_Inventory_Employee();
            try {
                uinv.start(mainStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        Scene sc=new Scene(main_layout,300, 150);
        mainStage.setMaxWidth(500);
        mainStage.setMaxHeight(500);
        main_layout.getChildren().add(option_bar);
        mainStage.setScene(sc);
        mainStage.setTitle("Employee");
        mainStage.setResizable(false);
        mainStage.show();
    }
}
