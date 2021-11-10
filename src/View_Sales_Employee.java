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

public class View_Sales_Employee extends Application{
    Stage window;
    TableView<Sales_Data> employee_table;

    public static void main(String args[]){launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        window.setTitle("Employees List");

        TableColumn<Sales_Data,Integer> emp_id =new TableColumn<>("Employee_id");
        TableColumn<Sales_Data,String> emp_name =new TableColumn<>("Employee_name ");
        TableColumn<Sales_Data,Integer> emp_sales =new TableColumn<>("Sales");
        TableColumn<Sales_Data, Date> sales_date =new TableColumn<>("Date");

        emp_id.setMinWidth(100);
        emp_id.setCellValueFactory(new PropertyValueFactory<>("Employee_id"));

        emp_name.setMinWidth(100);
        emp_name.setCellValueFactory(new PropertyValueFactory<>("Employee_name"));

        emp_sales.setMinWidth(100);
        emp_sales.setCellValueFactory(new PropertyValueFactory<>("Sales"));

        sales_date.setMinWidth(100);
        sales_date.setCellValueFactory(new PropertyValueFactory<>("Date"));



        employee_table = new TableView<>();
        employee_table.setItems(get_emp_list());
        employee_table.getColumns().addAll(emp_id,emp_name,emp_sales,sales_date);

        VBox emp_view_mode = new VBox();
//        emp_view_mode.getChildren().addAll(employee_table);
        Button close = new Button("Close");

        emp_view_mode.getChildren().addAll(employee_table,close );
        close.setOnAction(e->{
            window.close();
            admin adm = new admin();
            try {
                adm.start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        Scene view_scene = new Scene(emp_view_mode);
        window.setScene(view_scene);
        window.show();
    }

    public ObservableList<Sales_Data> get_emp_list()
    {
        String User_name = "root";
        String password = "Hacker@HG123";
        String database_name = "store";
        ObservableList<Sales_Data> emp = FXCollections.observableArrayList();
        try
        {
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/"+database_name,User_name,password);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from sales");


            while (rs.next())
            {
                emp.add(new Sales_Data(rs.getInt(1),
                        rs.getString(2),rs.getInt(3),
                        rs.getDate(4)));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return emp;
    }
}
