package hust.soict.hedspi.aims.screen.customer.controller;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class CartController {
    private Cart cart;
    private Store store;
    CartController(Store store, Cart cart){
        this.store = store;
        this.cart = cart;
    }
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnPlaceOrder;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;
    private void updateTotal() {
        float total = 0;
        for (Media media : cart.getItemsOrdered()) {
            total += media.getCost();
        }
        costLabel.setText(String.format("%.2f $", total));
    }

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        try {
            Disc playableMedia = (Disc) media;

            String message = String.format("Now playing: %s\nLength: %d minutes",
                    media.getTitle(), playableMedia.getLength());
            showAlert(Alert.AlertType.INFORMATION, "Playing Media", null, message);
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Play Error", null, e.getMessage());
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            tblMedia.getItems().remove(media); // cập nhật TableView
            updateTotal();
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
            fxmlLoader.setController(new ViewStoreController(store, cart));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(
                new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost"));
        if (cart.getItemsOrdered() != null)
            tblMedia.setItems(cart.getItemsOrdered());
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        updateTotal();
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observableValue, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });
    }
    void updateButtonBar(Media media){
        if(media == null){
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
        else {
            btnRemove.setVisible(true);
            if(media instanceof Playable){
                btnPlay.setVisible(true);
            }else {
                btnPlay.setVisible(false);
            }
        }
    }
    private void showAlert(Alert.AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Order Info");
            alert.setHeaderText(null);
            alert.setContentText("Your cart is empty. Nothing to order.");
            alert.showAndWait();
            return;
        }

        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirm Order");
        confirmAlert.setHeaderText("Place your order?");
        confirmAlert.setContentText("Are you sure you want to place this order?");

        confirmAlert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                cart.clear();
                tblMedia.refresh();
                updateTotal();
                btnPlay.setVisible(false);
                btnRemove.setVisible(false);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Order Placed");
                alert.setHeaderText(null);
                alert.setContentText("Your order has been placed successfully!");
                alert.showAndWait();
            }
        });
    }
}
