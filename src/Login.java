import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import java.sql.SQLException;

public class Login extends Application{
    @Override public void start(Stage mainStage) throws Exception {
        GridPane gp = new GridPane();
        gp.setVgap(25);
        gp.setHgap(10);
        gp.setPadding(new Insets(25, 0, 0, 15));
        Scene sc = new Scene(gp, 250, 250);
        sc.getStylesheets().add("style.css");
        mainStage.setResizable(false);
        mainStage.setScene(sc);
        mainStage.setTitle("Store Login");
        mainStage.show();

        Label username = new Label("Username: ");
        username.getStyleClass().add("login");
        gp.add(username, 0, 1);
        TextField user = new TextField();
        user.setPromptText("Enter username");
        gp.add(user, 1, 1);

        Label password = new Label("Password: ");
        password.getStyleClass().add("login");
        gp.add(password, 0, 2);
        PasswordField pass = new PasswordField();
        pass.setPromptText("Enter password");
        gp.add(pass, 1, 2);

        Button b = new Button("Login");
        b.getStyleClass().add("login-btn");
        gp.add(b, 1, 3);
        b.setOnAction(e -> {
            try {
                String role = Check_User.Check_Credentials(user.getText(),pass.getText());
                if(role.equalsIgnoreCase("admin"))
                {
                    System.out.println("login success as admin");
                    admin adm = new admin();
                    adm.start(mainStage);
                }
                else if(role.equalsIgnoreCase("employee"))
                {
                    System.out.println("Successfully logged in as Employee");
                    employee emp = new employee();
                    emp.start(mainStage);
                }

                else
                {
                    Alert_Box.display("Login Error","User Does not Exist");
                }

            } catch (SQLException ex) {
                System.out.println(ex.getLocalizedMessage());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}
