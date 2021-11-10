//VM Options : --module-path "C:\Users\bhava\Desktop\java-inventory-management-system\external libraries\javafx-sdk-17.0.0.1\lib" --add-modules javafx.controls,javafx.fxml

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;

public class admin extends Application{
    @Override public void start(Stage mainStage) throws Exception {
        HBox hb = new HBox();
        VBox mainLayout = new VBox();
        HBox list = new HBox();
        Button add = new Button("Add");
        Button Modify = new Button("Modify");

        Button viewEmp = new Button("View\nEmployee");
        hb.getChildren().add(viewEmp);
        Button manageEmp = new Button("Manage\nEmployee");
        hb.getChildren().add(manageEmp);

        Button viewSales = new Button("View\nSales");
        hb.getChildren().add(viewSales);

        Button updateInventory = new Button("Manage \nInventory");
        hb.getChildren().add(updateInventory);

        manageEmp.setOnAction(e -> {
//            list.setVisible(true);
        });


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

        mainLayout.getChildren().addAll(hb,list);

        Scene sc = new Scene(mainLayout, 300, 150);
        sc.getStylesheets().add("style.css");
        mainStage.setScene(sc);
        mainStage.setTitle("Admin");
        mainStage.show();
        mainStage.setResizable(false);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(15, 12, 15, 12));
        hb.setSpacing(10);
        hb.setStyle("-fx-background-color: #808080;");
    }
}
