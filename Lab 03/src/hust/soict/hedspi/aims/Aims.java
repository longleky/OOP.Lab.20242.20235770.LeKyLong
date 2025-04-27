package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import java.util.Collections;
import java.util.Scanner;

import static hust.soict.hedspi.aims.media.Media.COMPARE_BY_COST_TITLE;
import static hust.soict.hedspi.aims.media.Media.COMPARE_BY_TITLE_COST;

public class Aims {
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }
    public static void storeMenu() {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media’s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
    }
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }
    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avengers: Endgame", "Action", "Anthony Russo", 181, 19.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 14.99f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("The Lion King", "Animation", "Jon Favreau", 118, 12.99f);
// Tạo một danh sách Book
        Book book1 = new Book("The Hobbit", "Fantasy", 10.99f);
        book1.addAuthor("J.R.R. Tolkien");
        Book book2 = new Book("Clean Code", "Programming", 30.99f);
        book2.addAuthor("Robert C. Martin");
        Book book3 = new Book("Harry Potter and the Sorcerer's Stone", "Fantasy", 9.99f);
        book3.addAuthor("J.K. Rowling");
// Tạo một danh sách CD
        CompactDisc cd1 = new CompactDisc("Greatest Hits", "Pop", "John Doe", 15.99f, "Various Artists");
        cd1.addTrack(new Track("Hit Song 1", 210));
        cd1.addTrack(new Track("Hit Song 2", 190));
        CompactDisc cd2 = new CompactDisc("Rock Collection", "Rock", "Jane Smith", 17.99f, "Rock Band");
        cd2.addTrack(new Track("Rock Anthem", 230));
        cd2.addTrack(new Track("Ballad", 240));
        store.addMedia(dvd1,dvd2,dvd3,book1,book2,book3,cd1,cd2);
        cart.addMedia(dvd1, dvd2, dvd5, dvd6, book1, cd2);
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            showMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    int storeChoice = -1;
                    do {
                        store.printStore();
                        storeMenu();
                        storeChoice = Integer.parseInt(scanner.nextLine());
                        switch (storeChoice) {
                            case 1:
                                System.out.println("Enter the title of media:");
                                String title = scanner.nextLine();
                                Media media = store.searchByTitle(title);
                                if (media != null) {
                                    System.out.println(media.toString());
                                    int detailsChoice = -1;
                                    do{
                                        mediaDetailsMenu();
                                        detailsChoice = Integer.parseInt(scanner.nextLine());
                                        switch (detailsChoice){
                                            case 1:
                                                cart.addMedia(media);
                                                break;
                                            case 2:
                                                if(media instanceof Playable){
                                                    ((Playable) media).play();
                                                } else System.out.println("Cann't play");
                                                break;
                                            case 0:
                                                break;
                                            default:
                                                System.out.println("Invalid choice.");
                                        }
                                    } while(detailsChoice != 0);
                                    break;
                                } else {
                                    System.out.println("Media not found.");
                                }
                                break;
                            case 2:
                                System.out.println("Enter media title to add to cart:");
                                title = scanner.nextLine();
                                media = store.searchByTitle(title);
                                if (media != null) {
                                    cart.addMedia(media);
                                } else {
                                    System.out.println("Media not found.");
                                }
                                break;
                            case 3:
                                System.out.println("Enter media title to play:");
                                title = scanner.nextLine();
                                media = store.searchByTitle(title);
                                if (media != null){
                                    if(media instanceof Playable){
                                        ((Playable) media).play();
                                    } else {
                                        System.out.println("Media cannot be played.");
                                    }
                                } else {
                                    System.out.println("Media not found.");
                                }
                                break;
                            case 4:
                                cart.printCart();
                                break;
                        }
                    } while (storeChoice != 0);
                    break;
                case 2:
                    System.out.println("Add media/Remove media");
                    String update = scanner.nextLine();
                    if(update.equalsIgnoreCase("Add media")){
                        System.out.println("Enter media title to add: ");
                        String title = scanner.nextLine();
                        System.out.println("Category: ");
                        String category = scanner.nextLine();
                        System.out.println("Cost: ");
                        float cost = Float.parseFloat(scanner.nextLine());
                        System.out.println("Type (DVD/Book/CD): ");
                        String type = scanner.nextLine();
                        Media media = null;
                        if (type.equalsIgnoreCase("DVD")) {
                            System.out.println("Director: ");
                            String director = scanner.nextLine();
                            System.out.println("Length: ");
                            int length = Integer.parseInt(scanner.nextLine());
                            media = new DigitalVideoDisc(title, category, director, length, cost);
                        } else if (type.equalsIgnoreCase("Book")) {
                            media = new Book(title, category, cost);
                            System.out.println("Enter authors (type 'stop' to finish):");
                            while (true) {
                                String author = scanner.nextLine();
                                if (author.equalsIgnoreCase("stop")) break;
                                ((Book)media).addAuthor(author);
                            }
                        } else if (type.equalsIgnoreCase("CD")) {
                            System.out.println("Director:");
                            String director = scanner.nextLine();
                            System.out.println("Artist:");
                            String artist = scanner.nextLine();
                            CompactDisc cd = new CompactDisc(title, category, director, cost, artist);
                            System.out.println("Add tracks (type 'stop' to finish):");
                            while (true) {
                                System.out.println("Track title:");
                                String trackTitle = scanner.nextLine();
                                if (trackTitle.equalsIgnoreCase("stop")) break;
                                System.out.println("Track length:");
                                int trackLength = Integer.parseInt(scanner.nextLine());
                                cd.addTrack(new Track(trackTitle, trackLength));
                            }
                            media = cd;
                        }
                        if (media != null) store.addMedia(media);
                    } else if (update.equalsIgnoreCase("Remove media")) {
                        System.out.println("Enter title of media to remove:");
                        String title = scanner.nextLine();
                        Media media = store.searchByTitle(title);
                        if (media != null) {
                            store.removeMedia(media);
                        } else {
                            System.out.println("Media not found");
                        }
                    } else System.out.println("Invalid choice.");
                    break;
                case 3:
                    int cartChoice = -1;
                    do {
                        cart.printCart();
                        cartMenu();
                        cartChoice = Integer.parseInt(scanner.nextLine());
                        switch (cartChoice) {
                            case 1:
                                System.out.println("Filter by (id/title): ");
                                String filter = scanner.nextLine();
                                if (filter.equalsIgnoreCase("id")) {
                                    System.out.println("Enter ID:");
                                    int id = Integer.parseInt(scanner.nextLine());
                                    cart.searchById(id);
                                } else {
                                    System.out.println("Enter title:");
                                    String title = scanner.nextLine();
                                    cart.searchByTitle(title);
                                }
                                break;
                            case 2:
                                System.out.println("Sort by (title/cost):");
                                String sort = scanner.nextLine();
                                if (sort.equalsIgnoreCase("title")) {
                                    Collections.sort(cart.itemsOrdered, COMPARE_BY_TITLE_COST);
                                } else {
                                    Collections.sort(cart.itemsOrdered, COMPARE_BY_COST_TITLE);
                                }
                                break;
                            case 3:
                                System.out.println("Enter title of media to remove:");
                                String title = scanner.nextLine();
                                Media media = cart.searchTitle(title);
                                if (media != null) {
                                    cart.removeMedia(media);
                                } else {
                                    System.out.println("Media not found");
                                }
                                break;
                            case 4:
                                System.out.println("Enter title of media to play:");
                                title = scanner.nextLine();
                                media = cart.searchTitle(title);
                                if (media != null) {
                                    if (media instanceof Playable) {
                                        ((Playable) media).play();
                                    } else System.out.println("Media cannot be played.");
                                } else {
                                    System.out.println("Media not found");
                                }
                                break;
                            case 5:
                                System.out.println("Order created. Thank you!");
                                break;
                        }
                    }
                    while (cartChoice != 0  && cartChoice != 5);
                    break;
                case 0:
                    System.out.println("Thank you. Exiting AIMS.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}
