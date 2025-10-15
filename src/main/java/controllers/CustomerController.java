package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.CustomerDTO;

public class CustomerController {

    ObservableList<CustomerDTO> customerList = FXCollections.observableArrayList(
            new CustomerDTO("C001", "SE", "Malaka", "2005", 1860000, "Galgamuwa", "Kurunegala", "North Western", "60731")
    );

    @FXML
    private Button addBtn;

    @FXML
    private TextField address;

    @FXML
    private TextField city;

    @FXML
    private Button deleteBtn;

    @FXML
    private TextField dob;

    @FXML
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    private TextField postal;

    @FXML
    private TextField province;

    @FXML
    private TextField salary;

    @FXML
    private TableColumn<?, ?> tAddress;

    @FXML
    private TableColumn<?, ?> tCity;

    @FXML
    private TableColumn<?, ?> tDob;

    @FXML
    private TableColumn<?, ?> tId;

    @FXML
    private TableColumn<?, ?> tName;

    @FXML
    private TableColumn<?, ?> tPostal;

    @FXML
    private TableColumn<?, ?> tProvince;

    @FXML
    private TableColumn<?, ?> tSalary;

    @FXML
    private TableColumn<?, ?> tTitle;

    @FXML
    private TableView<CustomerDTO> table;

    @FXML
    private TextField title;

    @FXML
    private Button updateBtn;

    @FXML
    private Button clearBtn;



    @FXML
    void onAdd(ActionEvent event) {

        String enterdId = id.getText().trim();
        String enterdTitle = title.getText().trim();
        String enterdName = name.getText().trim();
        String enterdDob = dob.getText().trim();
        String enterdSalary = salary.getText().trim();
        String enterdAddress = address.getText().trim();
        String enterdCity = city.getText().trim();
        String enterdProvince = province.getText().trim();
        String enterdPostal = postal.getText().trim();

        if (enterdId.isEmpty() || enterdTitle.isEmpty() || enterdName.isEmpty() || enterdDob.isEmpty()
                || enterdSalary.isEmpty() || enterdAddress.isEmpty() || enterdCity.isEmpty()
                || enterdProvince.isEmpty() || enterdPostal.isEmpty()) {
            // Show alert
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Information");
            alert.setHeaderText("Cannot Add Customer");
            alert.setContentText("Please fill in all fields before adding a customer.");
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

        CustomerDTO newCustomer = new CustomerDTO(enterdId, enterdTitle, enterdName, enterdDob,
                salaryValue, enterdAddress, enterdCity, enterdProvince, enterdPostal);
        customerList.add(newCustomer);
        table.setItems(customerList);

        id.clear(); title.clear(); name.clear(); dob.clear(); salary.clear();
        address.clear(); city.clear(); province.clear(); postal.clear();
    }


    @FXML
    void onDelete(ActionEvent event) {
        CustomerDTO selectedItem = table.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            customerList.remove(selectedItem);
            table.setItems(customerList);
            id.clear();
            title.clear();
            name.clear();
            dob.clear();
            salary.clear();
            address.clear();
            city.clear();
            province.clear();
            postal.clear();
        } else {
            System.out.println("No customer selected for deletion.");
        }

    }

    @FXML
    void onUpdate(ActionEvent event) {
        System.out.println("update btn clicked");
        CustomerDTO selectedItem = table.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String enterdId = id.getText().trim();
            String enterdTitle = title.getText().trim();
            String enterdName = name.getText().trim();
            String enterdDob = dob.getText().trim();
            String enterdSalary = salary.getText().trim();
            String enterdAddress = address.getText().trim();
            String enterdCity = city.getText().trim();
            String enterdProvince = province.getText().trim();
            String enterdPostal = postal.getText().trim();

            if (enterdId.isEmpty() || enterdTitle.isEmpty() || enterdName.isEmpty() || enterdDob.isEmpty()
                    || enterdSalary.isEmpty() || enterdAddress.isEmpty() || enterdCity.isEmpty()
                    || enterdProvince.isEmpty() || enterdPostal.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Missing Information");
                alert.setHeaderText("Cannot Add Customer");
                alert.setContentText("Please fill in all fields before adding a customer.");
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
            selectedItem.setTitle(enterdTitle);
            selectedItem.setName(enterdName);
            selectedItem.setDob(enterdDob);
            selectedItem.setSalary(salaryValue);
            selectedItem.setAddress(enterdAddress);
            selectedItem.setCity(enterdCity);
            selectedItem.setProvince(enterdProvince);
            selectedItem.setPostalCode(enterdPostal);
            table.refresh();

        }else{
            System.out.println("selected customer is null");
        }

    }

    @FXML
    public void initialize() {
        tId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        tSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        tAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        tProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        tPostal.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        table.setItems(customerList);

        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                id.setText(((CustomerDTO) newValue).getId());
                title.setText(((CustomerDTO) newValue).getTitle());
                name.setText(((CustomerDTO) newValue).getName());
                dob.setText(((CustomerDTO) newValue).getDob());
                salary.setText(String.valueOf(((CustomerDTO) newValue).getSalary()));
                address.setText(((CustomerDTO) newValue).getAddress());
                city.setText(((CustomerDTO) newValue).getCity());
                province.setText(((CustomerDTO) newValue).getProvince());
                postal.setText(((CustomerDTO) newValue).getPostalCode());
            }
        });
    }


    public void onClear(ActionEvent actionEvent) {
        id.clear();
        title.clear();
        name.clear();
        dob.clear();
        salary.clear();
        address.clear();
        city.clear();
        province.clear();
        postal.clear();
        table.refresh();
    }
}
