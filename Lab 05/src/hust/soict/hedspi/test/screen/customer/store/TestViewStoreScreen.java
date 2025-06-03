package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart;
    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
        Book book1 = new Book("The Hobbit", "Fantasy", 10.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avengers: Endgame", "Action", "Anthony Russo", 181, 19.99f);
        book1.addAuthor("J.R.R. Tolkien");
        Book book2 = new Book("Clean Code", "Programming", 30.99f);
        book2.addAuthor("Robert C. Martin");
        Book book3 = new Book("Harry Potter and the Sorcerer's Stone", "Fantasy", 9.99f);
        book3.addAuthor("J.K. Rowling");
        CompactDisc cd1 = new CompactDisc("Greatest Hits", "Pop", "John Doe", 15.99f, "Various Artists");
        cd1.addTrack(new Track("Hit Song 1", 210));
        cd1.addTrack(new Track("Hit Song 2", 190));
        CompactDisc cd2 = new CompactDisc("Rock Collection", "Rock", "Jane Smith", 17.99f, "Rock Band");
        cd2.addTrack(new Track("Rock Anthem", 230));
        cd2.addTrack(new Track("Ballad", 240));
        cart.addMedia(dvd1,dvd3, book1,cd1, cd2);
        store.addMedia(dvd1,dvd2,dvd3, dvd4, book1,book2,book3,cd1,cd2);
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}