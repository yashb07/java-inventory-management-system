import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.sql.*;
import java.time.ZoneId;

public class Add_Sales extends Application{
    public static void main(String args[])
    {
        launch(args);
    }

    @Override
    public void start(Stage add_sales_stage) throws Exception
    {
        GridPane add_page = new GridPane();
        Label emp_id_label = new Label("Employee Id");
        Label emp_name_label = new Label("Name");
        Label emp_sales_label = new Label("Sales Amount");
        Label emp_sales_date_label = new Label("Date");

        HBox radio_box = new HBox();

        TextField emp_id = new TextField();
        TextField emp_name = new TextField();
        TextField emp_sales = new TextField();
        DatePicker dp = new DatePicker();

        add_page.setPadding(new Insets(10,10,10,10));
        add_page.setVgap(10);
        add_page.setHgap(10);

        add_page.add(emp_id_label,1,1);
        add_page.add(emp_id,2,1);
        add_page.add(emp_name_label,1,2);
        add_page.add(emp_name,2,2);
        add_page.add(emp_sales_label,1,3);
        add_page.add(emp_sales,2,3);
        add_page.add(emp_sales_date_label,1,4);
        add_page.add(dp,2,4);

        Button add_btn = new Button("Add");
        Button close_btn = new Button("Close");

        add_page.add(add_btn,1,6);
        add_page.add(close_btn,2,6);

        add_btn.setOnAction(e -> {
            try {
                String User_name = "root";
                String password = "Hacker@HG123";
                String database_name = "store";

                String query = "insert into sales values (?,?,?,?)";

                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/" + database_name, User_name, password);
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setInt(1,Integer.parseInt(emp_id.getText()));
                stmt.setString(2,emp_name.getText());
                stmt.setDouble(3,Double.parseDouble(emp_sales.getText()));
                java.util.Date date =
                        java.util.Date.from(dp.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                java.sql.Date dp1 = new java.sql.Date(date.getTime());
                stmt.setDate(4,dp1);
//                stmt.setDate(4, Date.valueOf(dp.getValue()));
                System.out.println(stmt);
                int rs = stmt.executeUpdate();

                if(rs>0)
                {
                    emp_id.clear();
                    emp_name.clear();
                    emp_sales.clear();
                    dp.getEditor().clear();

                    Alert_Box.display("Success Message","Data Added Successfully");
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        });

        close_btn.setOnAction(e ->{
            add_sales_stage.close();
            employee emp = new employee();
            try {
                emp.start(add_sales_stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Scene add_scene = new Scene(add_page);
        add_sales_stage.setTitle("Add Sales");
        add_sales_stage.setScene(add_scene);
        add_sales_stage.show();
    }
}