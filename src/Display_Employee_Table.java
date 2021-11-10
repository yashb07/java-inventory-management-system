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
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;

public class Display_Employee_Table extends Application{
    Stage window;
    TableView<Employee_Data> employee_table;

    public static void main(String args[]){launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        window.setTitle("Employees List");

        TableColumn<Employee_Data,Integer> emp_id =new TableColumn<>("Employee_id");
        TableColumn<Employee_Data,String> emp_name =new TableColumn<>("Name");
        TableColumn<Employee_Data,String> emp_username =new TableColumn<>("Username");
        TableColumn<Employee_Data,String> emp_password =new TableColumn<>("Password");
        TableColumn<Employee_Data,String> emp_role =new TableColumn<>("Role");

        emp_id.setMinWidth(100);
        emp_id.setCellValueFactory(new PropertyValueFactory<>("Employee_id"));

        emp_name.setMinWidth(100);
        emp_name.setCellValueFactory(new PropertyValueFactory<>("Name"));

        emp_username.setMinWidth(100);
        emp_username.setCellValueFactory(new PropertyValueFactory<>("Username"));

        emp_password.setMinWidth(100);
        emp_password.setCellValueFactory(new PropertyValueFactory<>("Password"));

        emp_role.setCellValueFactory(new PropertyValueFactory<>("Role"));


        employee_table = new TableView<>();
        employee_table.setItems(get_emp_list());
        employee_table.getColumns().addAll(emp_id,emp_name,emp_username,emp_password,emp_role);

        VBox emp_view_mode = new VBox();
        emp_view_mode.getChildren().addAll(employee_table);

        Scene view_scene = new Scene(emp_view_mode);
        window.setScene(view_scene);
        window.show();
    }

    public ObservableList<Employee_Data> get_emp_list()
    {
        String User_name = "root";
        String password = "Hacker@HG123";
        String database_name = "store";
        ObservableList<Employee_Data> emp = FXCollections.observableArrayList();
        try
        {
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/"+database_name,User_name,password);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from employee");


            while (rs.next())
            {
                emp.add(new Employee_Data(rs.getInt(1),
                        rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5)));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return emp;
    }
}
