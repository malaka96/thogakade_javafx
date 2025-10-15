package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {

    final String email = "m@gmail.com";
    final String password = "123123";

    @FXML
    private Button LoginBtn;

    @FXML
    private TextField emailTf;

    @FXML
    private TextField passwordTf;

    public void LoginOA(ActionEvent actionEvent) {
        String em = emailTf.getText();
        String ps = passwordTf.getText();

        if (em.isEmpty() || ps.isEmpty()) {
            new Alert(Alert.AlertType.ERROR,"Please enter both email and password").show();
        }

        if (em.equals(email) && ps.equals(password)) {


            Stage stage = new Stage();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/views/dashboard.fxml"))));
                stage.setTitle("Dashboard");
                Stage tempStage = (Stage) emailTf.getScene().getWindow();
                tempStage.close();

            } catch (
                    IOException e) {
                throw new RuntimeException(e);
            }
            stage.show();
            new Alert(Alert.AlertType.INFORMATION, "Login successful!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Invalid email or password.").show();
        }



    }
}
