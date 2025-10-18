package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.CustomerDTO;
import model.dto.ItemDTO;

import java.awt.event.ActionEvent;

public class ItemController {

    ObservableList<ItemDTO> itemList = FXCollections.observableArrayList(
            new ItemDTO("I001", "Smart Phone", "Electronic", 12, 46000)
    );

    @FXML
    private Button addBtn;

    @FXML
    private TextField category;

    @FXML
    private Button clearBtn;

    @FXML
    private TextField code;

    @FXML
    private Button deleteBtn;

    @FXML
    private TextField description;

    @FXML
    private TextField price;

    @FXML
    private TextField qty;

    @FXML
    private TableColumn<?, ?> tCategory;

    @FXML
    private TableColumn<?, ?> tCode;

    @FXML
    private TableColumn<?, ?> tDescription;

    @FXML
    private TableColumn<?, ?> tPrice;

    @FXML
    private TableColumn<?, ?> tQty;

    @FXML
    private TableView<ItemDTO> table;

    @FXML
    private Button updateBtn;

    @FXML
    void onAdd(ActionEvent event) {

    }

    @FXML
    void onClear(ActionEvent event) {

    }

    @FXML
    void onDelete(ActionEvent event) {

    }

    @FXML
    void onUpdate(ActionEvent event) {

    }

    public void onAdd(javafx.event.ActionEvent actionEvent) {
        String enterdCode = code.getText().trim();
        String enterdDescription = description.getText().trim();
        String enterdCategory = category.getText().trim();
        String enterdQty = qty.getText().trim();
        String enterdPrice = price.getText().trim();

        if (enterdCode.isEmpty() || enterdDescription.isEmpty() || enterdCategory.isEmpty()
                || enterdQty.isEmpty() || enterdPrice.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Information");
            alert.setHeaderText("Cannot Add Product");
            alert.setContentText("Please fill in all fields before adding a product.");
            alert.show();
            return;
        }

        int qtyValue;
        double priceValue;

        try{
            qtyValue = Integer.parseInt(enterdQty);
            priceValue = Double.parseDouble(enterdPrice);
        }catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Quantity Or Price");
            alert.setHeaderText("They must be a number");
            alert.setContentText("Please enter a valid numeric value.");
            alert.show();
            return;
        }

        ItemDTO newItem = new ItemDTO(enterdCode, enterdDescription, enterdCategory, qtyValue, priceValue);
        itemList.add(newItem);
        table.setItems(itemList);

        code.clear();
        description.clear();
        category.clear();
        qty.clear();
        price.clear();

    }

    public void onUpdate(javafx.event.ActionEvent actionEvent) {
        ItemDTO selectedItem = table.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String enterdCode = code.getText().trim();
            String enterdDescription = description.getText().trim();
            String enterdCategory = category.getText().trim();
            String enterdQty = qty.getText().trim();
            String enterdPrice = price.getText().trim();

            if (enterdCode.isEmpty() || enterdDescription.isEmpty() || enterdCategory.isEmpty()
                    || enterdQty.isEmpty() || enterdPrice.isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Missing Information");
                alert.setHeaderText("Cannot Add Product");
                alert.setContentText("Please fill in all fields before adding a product.");
                alert.show();
                return;
            }

            int qtyValue;
            double priceValue;

            try{
                qtyValue = Integer.parseInt(enterdQty);
                priceValue = Double.parseDouble(enterdPrice);
            }catch (NumberFormatException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Quantity Or Price");
                alert.setHeaderText("They must be a number");
                alert.setContentText("Please enter a valid numeric value.");
                alert.show();
                return;
            }
            selectedItem.setCode(enterdCode);
            selectedItem.setDescription(enterdDescription);
            selectedItem.setCategory(enterdCategory);
            selectedItem.setQuantity(qtyValue);
            selectedItem.setUnitPrice(priceValue);

            table.refresh();
        }else{
            System.out.println("Selected Item is null");
        }
    }

    public void onDelete(javafx.event.ActionEvent actionEvent) {
        ItemDTO selectedItem = table.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            itemList.remove(selectedItem);
            table.setItems(itemList);

            code.clear();
            description.clear();
            category.clear();
            qty.clear();
            price.clear();
        } else {
            System.out.println("No item selected for deletion.");
        }
    }

    public void onClear(javafx.event.ActionEvent actionEvent) {
        code.clear();
        description.clear();
        category.clear();
        qty.clear();
        price.clear();
    }

    @FXML
    public void initialize() {
        tCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        tDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        tQty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        table.setItems(itemList);

        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                code.setText(((ItemDTO)newValue).getCode());
                description.setText(((ItemDTO)newValue).getDescription());
                category.setText(((ItemDTO)newValue).getCategory());
                qty.setText(String.valueOf(((ItemDTO)newValue).getQuantity()));
                price.setText(String.valueOf(((ItemDTO)newValue).getUnitPrice()));
            }
        });
    }
}
