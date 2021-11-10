import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.sql.*;

public class View_Inventory_data extends Application{
    Stage window;
    TableView<Inventory_Data> inventory_table;

    public static void main(String args[]){launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        window.setTitle("Inventory");

        TableColumn<Inventory_Data,String> item_id =new TableColumn<>("Item_id");
        TableColumn<Inventory_Data,String> item_type =new TableColumn<>("Item_Type");
        TableColumn<Inventory_Data,String> item_name =new TableColumn<>("Item_Name");
        TableColumn<Inventory_Data,Integer> item_quantity =new TableColumn<>("Quantity");
        TableColumn<Inventory_Data,Double> item_price =new TableColumn<>("Price");
        TableColumn<Inventory_Data, Date> expiry_date =new TableColumn<>("Expiry Date");

        item_id.setMinWidth(100);
        item_id.setCellValueFactory(new PropertyValueFactory<>("Item_id"));

        item_type.setMinWidth(100);
        item_type.setCellValueFactory(new PropertyValueFactory<>("item_type"));

        item_name.setMinWidth(100);
        item_name.setCellValueFactory(new PropertyValueFactory<>("item_name"));

        item_quantity.setMinWidth(100);
        item_quantity.setCellValueFactory(new PropertyValueFactory<>("item_quantity"));

        item_price.setMinWidth(100);
        item_price.setCellValueFactory(new PropertyValueFactory<>("item_price"));

        expiry_date.setMinWidth(100);
        expiry_date.setCellValueFactory(new PropertyValueFactory<>("date"));



        inventory_table = new TableView<>();
        inventory_table.setItems(get_emp_list());
        inventory_table.getColumns().addAll(item_id,item_type,item_name,item_quantity,item_price,expiry_date);

        VBox emp_view_mode = new VBox();
        emp_view_mode.getChildren().addAll(inventory_table);

        Scene view_scene = new Scene(emp_view_mode);
        window.setScene(view_scene);
        window.show();
    }

    public ObservableList<Inventory_Data> get_emp_list()
    {
        String User_name = "root";
        String password = "Hacker@HG123";
        String database_name = "store";
        ObservableList<Inventory_Data> emp = FXCollections.observableArrayList();
        try
        {
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/"+database_name,User_name,password);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from inventory");


            while (rs.next())
            {
                emp.add(new Inventory_Data(rs.getString(1),
                        rs.getString(2),rs.getString(3),
                        rs.getInt(4),rs.getDouble(5),rs.getDate(6)));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return emp;
    }
}