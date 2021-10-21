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
        Button manage_view = new Button("view stock");
        Button manage_add = new Button("Add sales");
        option_bar.getChildren().addAll(manage_view,manage_add);
        option_bar.setSpacing(5);

        //layout as an object for add sales
        GridPane gp = new GridPane();
        Label employee_id_label = new Label("Employee Id");
        Label employee_name_label = new Label("Employee Name");
        Label employee_sales_label = new Label("Sales");
        Label employee_sales_date_label = new Label("Sales Date");

        TextField employee_id = new TextField();
        TextField employee_name = new TextField();
        TextField employee_sales = new TextField();
        DatePicker sales_date  = new DatePicker();
        Button btn_add = new Button("Add");
        Button btn_close = new Button("Close");

        gp.setHgap(10);
        gp.setVgap(20);

        gp.setPadding(new Insets(10,10,10,10));

        gp.add(employee_id_label,1,3);
        gp.add(employee_name_label,1,4);
        gp.add(employee_sales_label,1,5);
        gp.add(employee_sales_date_label,1,6);
        gp.add(employee_id,2,3);
        gp.add(employee_name,2,4);
        gp.add(employee_sales,2,5);
        gp.add(sales_date,2,6);
        gp.add(btn_add,1,7);
        gp.add(btn_close,2,7);
        employee_id.setPrefWidth(350);
        employee_id.setMaxWidth(350);
        employee_name.setPrefWidth(350);
        employee_name.setMaxWidth(350);
        employee_sales.setPrefWidth(350);
        employee_sales.setMaxWidth(350);

        main_layout.getChildren().add(gp);
        Scene sc=new Scene(main_layout,500, 500);
        mainStage.setMaxWidth(500);
        mainStage.setMaxHeight(500);
        main_layout.getChildren().add(option_bar);
        mainStage.setScene(sc);
        mainStage.show();
    }
}
