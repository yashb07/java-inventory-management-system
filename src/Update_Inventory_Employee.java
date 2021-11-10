import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.sql.*;
import java.time.ZoneId;

public class Update_Inventory_Employee extends Application{
    public static void main(String args[])
    {
        launch(args);
    }

    @Override
    public void start(Stage update_emp_stage) throws Exception
    {
        GridPane add_page = new GridPane();
        Label item_id_label = new Label("Item Id");
        Label item_type_label = new Label("Item type");
        Label item_name_label = new Label("Item Name");
        Label item_quantity_label = new Label("Item Quantity");
        Label item_price_label = new Label("Item Price");
        Label item_expiry_date_label = new Label("Expiry Date");

        TextField item_id = new TextField();
        TextField item_type = new TextField();
        TextField item_name = new TextField();
        TextField item_quantity = new TextField();
        TextField item_price = new TextField();
        DatePicker dp = new DatePicker();

        add_page.setPadding(new Insets(10,10,10,10));
        add_page.setVgap(10);
        add_page.setHgap(10);

        add_page.add(item_id_label,1,1);
        add_page.add(item_id,2,1);
        add_page.add(item_type_label,1,2);
        add_page.add(item_type,2,2);
        add_page.add(item_name_label,1,3);
        add_page.add(item_name,2,3);
        add_page.add(item_quantity_label,1,4);
        add_page.add(item_quantity,2,4);
        add_page.add(item_price_label,1,5);
        add_page.add(item_price,2,5);
        add_page.add(item_expiry_date_label,1,6);
        add_page.add(dp,2,6);

        Button add_btn = new Button("Add");
        Button modify_btn = new Button("Modify");
        Button delete_btn = new Button("Delete");
        Button close_btn = new Button("Close");

        add_page.add(add_btn,1,7);
        add_page.add(modify_btn,2,7);
        add_page.add(delete_btn,3,7);
        add_page.add(close_btn,4,7);

        add_btn.setOnAction(e -> {
            try {

                String User_name = "root";
                String password = "Hacker@HG123";
                String database_name = "store";

                java.util.Date date =
                        java.util.Date.from(dp.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                java.sql.Date dp1 = new java.sql.Date(date.getTime());

                String query1 = "INSERT INTO inventory VALUES("+item_id.getText()+" , '"+ item_type.getText()+"', '"+item_name.getText()+"',"+item_quantity.getText()+","+item_price.getText()+",'"+dp1+"')";

                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/" + database_name, User_name, password);
                PreparedStatement stmt = con.prepareStatement(query1);
                System.out.println(stmt);
                int rs = stmt.executeUpdate();

                if(rs>0)
                {
                    item_id.clear();
                    item_type.clear();
                    item_name.clear();
                    item_quantity.clear();
                    item_price.clear();
                    dp.getEditor().clear();
                    Alert_Box.display("Success Message","Data Added Successfully");
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        });
        modify_btn.setOnAction(e -> {
            try {
                String User_name = "root";
                String password = "Hacker@HG123";
                String database_name = "store";

                java.util.Date date =
                        java.util.Date.from(dp.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                java.sql.Date dp1 = new java.sql.Date(date.getTime());

                String query = "update inventory set Item_type = '"+item_type.getText()+"', Item_Name = '"+item_name.getText()+"', Item_Quantity = "+item_quantity.getText()+",Item_Price  = "+item_price.getText()+", Expiry_date= '"+dp1+"'  where Item_Id = "+item_id.getText();

                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/" + database_name, User_name, password);
                PreparedStatement stmt = con.prepareStatement(query);
                System.out.println(stmt);
                int rs = stmt.executeUpdate();

                if(rs>0)
                {
                    item_id.clear();
                    item_type.clear();
                    item_name.clear();
                    item_quantity.clear();
                    item_price.clear();
                    dp.getEditor().clear();
                    Alert_Box.display("Success Message","Data Modified Successfully");
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        });
        delete_btn.setOnAction(e -> {
            try {
                String User_name = "root";
                String password = "Hacker@HG123";
                String database_name = "store";

                String query = "delete from inventory where Item_Id = "+item_id.getText();

                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/" + database_name, User_name, password);
                PreparedStatement stmt = con.prepareStatement(query);

                int rs = stmt.executeUpdate();

                if(rs>0)
                {
                    item_id.clear();
                    item_type.clear();
                    item_name.clear();
                    item_quantity.clear();
                    item_price.clear();
                    dp.getEditor().clear();
                    Alert_Box.display("Success Message","Data Deleted Successfully");
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        });

        close_btn.setOnAction(e ->{update_emp_stage.close();
            employee adm = new employee();
            try {
                adm.start(update_emp_stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }});

        Scene add_scene = new Scene(add_page,500,400);
        update_emp_stage.setTitle("Modify Employee");
        update_emp_stage.setScene(add_scene);
        update_emp_stage.show();
    }
}
