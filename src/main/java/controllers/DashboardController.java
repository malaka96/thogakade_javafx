package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DashboardController {

    @FXML
    private Button backBtn;

    @FXML
    private Button cmBtn;

    @FXML
    private Button emBtn;

    @FXML
    private Button imBtn;

    @FXML
    private Button smBtn;

    @FXML
    void backOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try{
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/views/login_form.fxml"))));
            Stage tempStage = (Stage) smBtn.getScene().getWindow();
            tempStage.close();
        }catch (Exception e){
            throw new RuntimeException();
        }
        stage.show();
    }

    @FXML
    void cmOnAction(ActionEvent event) {

    }

    @FXML
    void emOnAction(ActionEvent event) {

    }

    @FXML
    void imOnAction(ActionEvent event) {

    }

    @FXML
    void smOnAction(ActionEvent event) {

    }

}
