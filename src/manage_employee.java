import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class manage_employee extends Application {
        @Override public void start(Stage mainStage) throws Exception {
            VBox sp = new VBox();
            HBox hb = new HBox();
//            HBox hb = new HBox();
            HBox hb2 = new HBox();
//            VBox mainLayout = new VBox();

            Button viewEmp = new Button("View\nEmployee");
            hb.getChildren().add(viewEmp);
            Button manageEmp = new Button("Manage\nEmployee");
            hb.getChildren().add(manageEmp);
            Button viewSales = new Button("View\nSales");
            hb.getChildren().add(viewSales);
            Button updateInventory = new Button("Manage \nInventory");
            hb.getChildren().add(updateInventory);

            Button addEmployee = new Button("Add \nEmployee");
            hb2.getChildren().add(addEmployee);
            Button modifyEmployee = new Button("Modify \nEmployee");
            hb2.getChildren().add(modifyEmployee);

            viewEmp.setOnAction(e -> {
                try {
                    Display_Employee_Table adEmp = new Display_Employee_Table();
                    adEmp.start(mainStage);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            });

            updateInventory.setOnAction(e -> {
                try {
                    updateInventory upInv = new updateInventory();
                    upInv.start(mainStage);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            });


            viewSales.setOnAction(e -> {
                try {
                    viewSales vSales = new viewSales();
                    vSales.start(mainStage);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            });

            addEmployee.setOnAction(e -> {
                try {
                    add_employee addEmp = new add_employee();
                    addEmp.start(mainStage);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            });

            modifyEmployee.setOnAction(e -> {
                try {
                    Update_Employee updateEmp = new Update_Employee();
                    updateEmp.start(mainStage);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            });

            sp.getChildren().add(hb);
            sp.getChildren().add(hb2);
            Scene sc = new Scene(sp, 300, 150);
            sc.getStylesheets().add("style.css");
            mainStage.setScene(sc);
            mainStage.setTitle("Admin");
            mainStage.show();
            mainStage.setResizable(false);
//            hb.setAlignment(Pos.);
            hb.setPadding(new Insets(15, 12, 15, 12));
            hb.setSpacing(10);
            hb.setStyle("-fx-background-color: #808080;");
            hb2.setPadding(new Insets(15, 12, 15, 12));
            hb2.setSpacing(10);
            hb2.setStyle("-fx-background-color: #808080;");
        }

}
