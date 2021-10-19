import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

import javax.swing.*;

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
        mainStage.setTitle("Click Label");
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
            var admin = 1;
            try {
                if (admin == 1) {
                    admin adm = new admin();
                    adm.start(mainStage);
                }
                else if (admin == 0) {
                    employee emp = new employee();
                    emp.start(mainStage);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}
