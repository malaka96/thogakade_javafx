package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.SupplierDTO;

public class SupplierController {

    ObservableList<SupplierDTO> supplierList = FXCollections.observableArrayList(
            new SupplierDTO("S001", "Malaka", "TechNova", "Galgamuwa", "Kurunegala", "North Western", "60731", "0771234567", "malaka@technova.com")
    );

    @FXML private Button addBtn;
    @FXML private Button deleteBtn;
    @FXML private Button updateBtn;
    @FXML private Button clearBtn;

    @FXML private TextField id;
    @FXML private TextField name;
    @FXML private TextField company;
    @FXML private TextField address;
    @FXML private TextField city;
    @FXML private TextField province;
    @FXML private TextField postal;
    @FXML private TextField phone;
    @FXML private TextField email;

    @FXML private TableColumn<SupplierDTO, String> tId;
    @FXML private TableColumn<SupplierDTO, String> tName;
    @FXML private TableColumn<SupplierDTO, String> tCompany;
    @FXML private TableColumn<SupplierDTO, String> tAddress;
    @FXML private TableColumn<SupplierDTO, String> tCIty;
    @FXML private TableColumn<SupplierDTO, String> tProvince;
    @FXML private TableColumn<SupplierDTO, String> tPostal;
    @FXML private TableColumn<SupplierDTO, String> tPhone;
    @FXML private TableColumn<SupplierDTO, String> tEmail;

    @FXML private TableView<SupplierDTO> table;

    @FXML
    void onAdd(ActionEvent event) {
        String enterdId = id.getText().trim();
        String enterdName = name.getText().trim();
        String enterdCompany = company.getText().trim();
        String enterdAddress = address.getText().trim();
        String enterdCity = city.getText().trim();
        String enterdProvince = province.getText().trim();
        String enterdPostal = postal.getText().trim();
        String enterdPhone = phone.getText().trim();
        String enterdEmail = email.getText().trim();

        if (enterdId.isEmpty() || enterdName.isEmpty() || enterdCompany.isEmpty() || enterdAddress.isEmpty()
                || enterdCity.isEmpty() || enterdProvince.isEmpty() || enterdPostal.isEmpty()
                || enterdPhone.isEmpty() || enterdEmail.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Information");
            alert.setHeaderText("Cannot Add Supplier");
            alert.setContentText("Please fill in all fields before adding a supplier.");
            alert.show();
            return;
        }

        SupplierDTO newSupplier = new SupplierDTO(enterdId, enterdName, enterdCompany, enterdAddress,
                enterdCity, enterdProvince, enterdPostal, enterdPhone, enterdEmail);
        supplierList.add(newSupplier);
        table.setItems(supplierList);

        clearFields();
    }

    @FXML
    void onDelete(ActionEvent event) {
        SupplierDTO selectedItem = table.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            supplierList.remove(selectedItem);
            table.setItems(supplierList);
            clearFields();
        } else {
            System.out.println("No supplier selected for deletion.");
        }
    }

    @FXML
    void onUpdate(ActionEvent event) {
        SupplierDTO selectedItem = table.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String enterdId = id.getText().trim();
            String enterdName = name.getText().trim();
            String enterdCompany = company.getText().trim();
            String enterdAddress = address.getText().trim();
            String enterdCity = city.getText().trim();
            String enterdProvince = province.getText().trim();
            String enterdPostal = postal.getText().trim();
            String enterdPhone = phone.getText().trim();
            String enterdEmail = email.getText().trim();

            if (enterdId.isEmpty() || enterdName.isEmpty() || enterdCompany.isEmpty() || enterdAddress.isEmpty()
                    || enterdCity.isEmpty() || enterdProvince.isEmpty() || enterdPostal.isEmpty()
                    || enterdPhone.isEmpty() || enterdEmail.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Missing Information");
                alert.setHeaderText("Cannot Update Supplier");
                alert.setContentText("Please fill in all fields before updating.");
                alert.show();
                return;
            }

            selectedItem.setId(enterdId);
            selectedItem.setName(enterdName);
            selectedItem.setCompany(enterdCompany);
            selectedItem.setAddress(enterdAddress);
            selectedItem.setCity(enterdCity);
            selectedItem.setProvince(enterdProvince);
            selectedItem.setPostal(enterdPostal);
            selectedItem.setPhone(enterdPhone);
            selectedItem.setEmail(enterdEmail);
            table.refresh();
        } else {
            System.out.println("No supplier selected for update.");
        }
    }

    @FXML
    void onClear(ActionEvent event) {
        clearFields();
        table.refresh();
    }

    private void clearFields() {
        id.clear(); name.clear(); company.clear(); address.clear(); city.clear();
        province.clear(); postal.clear(); phone.clear(); email.clear();
    }

    @FXML
    public void initialize() {
        tId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tName.setCellValueFactory(new PropertyValueFactory<>("name"));
        //tName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tCompany.setCellValueFactory(new PropertyValueFactory<>("company"));
        tAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tCIty.setCellValueFactory(new PropertyValueFactory<>("city"));
        tProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        tPostal.setCellValueFactory(new PropertyValueFactory<>("postal"));
        tPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        table.setItems(supplierList);

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                id.setText(newSelection.getId());
                name.setText(newSelection.getName());
                company.setText(newSelection.getCompany());
                address.setText(newSelection.getAddress());
                city.setText(newSelection.getCity());
                province.setText(newSelection.getProvince());
                postal.setText(newSelection.getPostal());
                phone.setText(newSelection.getPhone());
                email.setText(newSelection.getEmail());
            }
        });
    }
}
