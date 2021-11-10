import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.sql.*;


public class add_employee extends Application {


    public static void main(String args[])
    {
        launch(args);
    }

    @Override
    public void start(Stage add_emp_stage) throws Exception
    {
        GridPane add_page = new GridPane();
        Label emp_id_label = new Label("Employee Id");
        Label emp_name_label = new Label("Name");
        Label emp_username_label = new Label("Username");
        Label emp_password_label = new Label("Password");
        Label emp_role_label = new Label("Role");

        HBox radio_box = new HBox();

        TextField emp_id = new TextField();
        TextField emp_name = new TextField();
        TextField emp_username = new TextField();
        PasswordField emp_password = new PasswordField();
        TextField emp_role = new TextField();

        RadioButton admin = new RadioButton("admin");
        RadioButton employee = new RadioButton("employee");

        ToggleGroup tg = new ToggleGroup();

        admin.setToggleGroup(tg);
        employee.setToggleGroup(tg);

        radio_box.setSpacing(10);
        radio_box.setPadding(new Insets(10,10,10,10));
        radio_box.getChildren().addAll(admin,employee);
        add_page.setPadding(new Insets(10,10,10,10));
        add_page.setVgap(10);
        add_page.setHgap(10);

        add_page.add(emp_id_label,1,1);
        add_page.add(emp_id,2,1);
        add_page.add(emp_name_label,1,2);
        add_page.add(emp_name,2,2);
        add_page.add(emp_username_label,1,3);
        add_page.add(emp_username,2,3);
        add_page.add(emp_password_label,1,4);
        add_page.add(emp_password,2,4);
        add_page.add(emp_role_label,1,5);
        add_page.add(radio_box,2,5);

        Button add_btn = new Button("Add");
        Button close_btn = new Button("Close");

        add_page.add(add_btn,1,6);
        add_page.add(close_btn,2,6);

        add_btn.setOnAction(e -> {
            try {
                String User_name = "root";
                String password = "Hacker@HG123";
                String database_name = "store";

                String role = "";
                if (admin.isSelected()) {
                    role = "admin";
                } else if (employee.isSelected()) {
                    role = "employee";
                }


                String query = "insert into employee values (?,?,?,?,?)";

                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/" + database_name, User_name, password);
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setInt(1,Integer.parseInt(emp_id.getText()));
                stmt.setString(2,emp_name.getText());
                stmt.setString(3,emp_username.getText());
                stmt.setString(4,emp_password.getText());
                stmt.setString(5,role);
                int rs = stmt.executeUpdate();

                if(rs>0)
                {
                    emp_id.clear();
                    emp_name.clear();
                    emp_username.clear();
                    emp_password.clear();
                    emp_role.clear();
                    admin.setSelected(false);
                    Alert_Box.display("Success Message","Data Added Successfully");
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        });

        close_btn.setOnAction(e ->{add_emp_stage.close();
            admin adm = new admin();
            try {
                adm.start(add_emp_stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }});

        Scene add_scene = new Scene(add_page);
        add_emp_stage.setTitle("Add New Employee");
        add_emp_stage.setScene(add_scene);
        add_emp_stage.show();
    }
}

