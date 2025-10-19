package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.security.spec.ECField;

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
            stage.setTitle("Login Form");
            Stage tempStage = (Stage) smBtn.getScene().getWindow();
            tempStage.close();
        }catch (Exception e){
            throw new RuntimeException();
        }
        stage.show();
    }

    @FXML
    void cmOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try{
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/views/customer_dashboard.fxml"))));
            stage.setTitle("Customer Dashboard");
            Stage currentStage = (Stage) backBtn.getScene().getWindow();
            currentStage.close();
        }catch (Exception e){
            throw new RuntimeException();
        }
        stage.show();

    }

    @FXML
    void emOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try{
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/views/employee_dashboard.fxml"))));
            stage.setTitle("Employee Dashboard");
            Stage currentStage = (Stage) backBtn.getScene().getWindow();
            currentStage.close();
        }catch (Exception e) {
            System.out.println(e.getMessage());
//            throw new RuntimeException();
        }
        stage.show();

    }

    @FXML
    void imOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try{
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/views/item_dashboard.fxml"))));
            stage.setTitle("Item Dashboard");
            Stage currentStage = (Stage) backBtn.getScene().getWindow();
            currentStage.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
//            throw new RuntimeException();
        }
        stage.show();
    }

    @FXML
    void smOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try{
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/views/supplier_dashboard.fxml"))));
            stage.setTitle("Staff Dashboard");
            Stage currentStage = (Stage) backBtn.getScene().getWindow();
            currentStage.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
//            throw new RuntimeException();
        }
        stage.show();

    }

}
