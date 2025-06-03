package hust.soict.hedspi.aims.screen.customer.controller;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Disc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.scene.layout.HBox;

public class ItemController {
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;
    private Media media;
    private Cart cart;
    public ItemController(Media media, Cart cart){
        this.media = media;
        this.cart = cart;
    }
    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }
    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        try {
            cart.addMedia(media);
            showAlert(Alert.AlertType.INFORMATION, "Success", null, "Added to cart successfully!");
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", null, "Cannot add to cart: " + e.getMessage());
        }
    }
    @FXML
    void btnPlayClicked(ActionEvent event) {
        try {
            Disc playableMedia = (Disc) media;

            String message = String.format("Now playing: %s\nLength: %d minutes",
                    media.getTitle(), playableMedia.getLength());
            showAlert(Alert.AlertType.INFORMATION, "Playing Media", null, message);
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Play Error", null, e.getMessage());
        }
    }
    private void showAlert(Alert.AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}