package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.EmployeeDTO;

public class EmployeeController {

    ObservableList<EmployeeDTO> employeeList = FXCollections.observableArrayList(
            new EmployeeDTO("E001", "Malaka", "200512345678", "2005-10-19", "Manager", 150000.0, "0771234567", "Galgamuwa", "2023-01-01", "Active")
    );

    @FXML private Button addBtn;
    @FXML private Button deleteBtn;
    @FXML private Button updateBtn;
    @FXML private Button clearBtn;

    @FXML private TextField id;
    @FXML private TextField name;
    @FXML private TextField nic;
    @FXML private TextField dob;
    @FXML private TextField position;
    @FXML private TextField salary;
    @FXML private TextField phone;
    @FXML private TextField address;
    @FXML private TextField joinedDate;
    @FXML private TextField status;

    @FXML private TableColumn<EmployeeDTO, String> tId;
    @FXML private TableColumn<EmployeeDTO, String> tName;
    @FXML private TableColumn<EmployeeDTO, String> tNic;
    @FXML private TableColumn<EmployeeDTO, String> tDob;
    @FXML private TableColumn<EmployeeDTO, String> tPosition;
    @FXML private TableColumn<EmployeeDTO, Double> tSalary;
    @FXML private TableColumn<EmployeeDTO, String> tPhone;
    @FXML private TableColumn<EmployeeDTO, String> tAddress;
    @FXML private TableColumn<EmployeeDTO, String> tJoinedDate;
    @FXML private TableColumn<EmployeeDTO, String> tStatus;

    @FXML private TableView<EmployeeDTO> table;

    @FXML
    void onAdd(javafx.event.ActionEvent event) {
        String enterdId = id.getText().trim();
        String enterdName = name.getText().trim();
        String enterdNic = nic.getText().trim();
        String enterdDob = dob.getText().trim();
        String enterdPosition = position.getText().trim();
        String enterdSalary = salary.getText().trim();
        String enterdPhone = phone.getText().trim();
        String enterdAddress = address.getText().trim();
        String enterdJoinedDate = joinedDate.getText().trim();
        String enterdStatus = status.getText().trim();

        if (enterdId.isEmpty() || enterdName.isEmpty() || enterdNic.isEmpty() || enterdDob.isEmpty()
                || enterdPosition.isEmpty() || enterdSalary.isEmpty() || enterdPhone.isEmpty()
                || enterdAddress.isEmpty() || enterdJoinedDate.isEmpty() || enterdStatus.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Information");
            alert.setHeaderText("Cannot Add Employee");
            alert.setContentText("Please fill in all fields before adding an employee.");
            alert.show();
            return;
        }

        double salaryValue;
        try {
            salaryValue = Double.parseDouble(enterdSalary);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Salary");
            alert.setHeaderText("Salary must be a number");
            alert.setContentText("Please enter a valid numeric salary.");
            alert.show();
            return;
        }

        EmployeeDTO newEmployee = new EmployeeDTO(enterdId, enterdName, enterdNic, enterdDob,
                enterdPosition, salaryValue, enterdPhone, enterdAddress, enterdJoinedDate, enterdStatus);
        employeeList.add(newEmployee);
        table.setItems(employeeList);
        clearFields();
    }

    @FXML
    void onUpdate(javafx.event.ActionEvent event) {
        EmployeeDTO selectedItem = table.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String enterdId = id.getText().trim();
            String enterdName = name.getText().trim();
            String enterdNic = nic.getText().trim();
            String enterdDob = dob.getText().trim();
            String enterdPosition = position.getText().trim();
            String enterdSalary = salary.getText().trim();
            String enterdPhone = phone.getText().trim();
            String enterdAddress = address.getText().trim();
            String enterdJoinedDate = joinedDate.getText().trim();
            String enterdStatus = status.getText().trim();

            if (enterdId.isEmpty() || enterdName.isEmpty() || enterdNic.isEmpty() || enterdDob.isEmpty()
                    || enterdPosition.isEmpty() || enterdSalary.isEmpty() || enterdPhone.isEmpty()
                    || enterdAddress.isEmpty() || enterdJoinedDate.isEmpty() || enterdStatus.isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Missing Information");
                alert.setHeaderText("Cannot Update Employee");
                alert.setContentText("Please fill in all fields before updating.");
                alert.show();
                return;
            }

            double salaryValue;
            try {
                salaryValue = Double.parseDouble(enterdSalary);
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Salary");
                alert.setHeaderText("Salary must be a number");
                alert.setContentText("Please enter a valid numeric salary.");
                alert.show();
                return;
            }

            selectedItem.setId(enterdId);
            selectedItem.setName(enterdName);
            selectedItem.setNic(enterdNic);
            selectedItem.setDob(enterdDob);
            selectedItem.setPosition(enterdPosition);
            selectedItem.setSalary(salaryValue);
            selectedItem.setPhone(enterdPhone);
            selectedItem.setAddress(enterdAddress);
            selectedItem.setJoinedDate(enterdJoinedDate);
            selectedItem.setStatus(enterdStatus);
            table.refresh();
        } else {
            System.out.println("No employee selected for update.");
        }
    }

    @FXML
    void onDelete(javafx.event.ActionEvent event) {
        EmployeeDTO selectedItem = table.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            employeeList.remove(selectedItem);
            table.setItems(employeeList);
            clearFields();
        } else {
            System.out.println("No employee selected for deletion.");
        }
    }

    @FXML
    void onClear(javafx.event.ActionEvent event) {
        clearFields();
        table.refresh();
    }

    private void clearFields() {
        id.clear(); name.clear(); nic.clear(); dob.clear(); position.clear();
        salary.clear(); phone.clear(); address.clear(); joinedDate.clear(); status.clear();
    }

    @FXML
    public void initialize() {
        tId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        tDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        tPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        tSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        tPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tJoinedDate.setCellValueFactory(new PropertyValueFactory<>("joinedDate"));
        tStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        table.setItems(employeeList);

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                id.setText(newSelection.getId());
                name.setText(newSelection.getName());
                nic.setText(newSelection.getNic());
                dob.setText(newSelection.getDob());
                position.setText(newSelection.getPosition());
                salary.setText(String.valueOf(newSelection.getSalary()));
                phone.setText(newSelection.getPhone());
                address.setText(newSelection.getAddress());
                joinedDate.setText(newSelection.getJoinedDate());
                status.setText(newSelection.getStatus());
            }
        });
    }
}
