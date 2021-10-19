import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;

public class adminEmployee extends Application{
    @Override public void start(Stage mainStage) throws Exception {
        HBox hb = new HBox();
        Scene sc = new Scene(hb, 400, 600);
        sc.getStylesheets().add("style.css");
        mainStage.setScene(sc);
        mainStage.setTitle("Manage Employees");
        mainStage.show();
        hb.setAlignment(Pos.TOP_CENTER);
        hb.setPadding(new Insets(15, 12, 15, 12));
        hb.setSpacing(10);
        hb.setStyle("-fx-background-color: #808080;");

        Button manageEmp = new Button("Manage\nEmployee");
        hb.getChildren().add(manageEmp);
        Button updateInventory = new Button("Update\nInventory");
        hb.getChildren().add(updateInventory);
        Button viewStocks = new Button("View\nStocks");
        hb.getChildren().add(viewStocks);
        Button viewSales = new Button("View\nSales");
        hb.getChildren().add(viewSales);

        manageEmp.setOnAction(e -> {
            try {
                adminEmployee adEmp = new adminEmployee();
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

        viewStocks.setOnAction(e -> {
            try {
                viewStocks vStock = new viewStocks();
                vStock.start(mainStage);
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
    }
}