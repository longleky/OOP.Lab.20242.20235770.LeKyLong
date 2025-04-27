package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<>();
    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    public void addMedia(Media media){
        if(itemsOrdered.size() < MAX_NUMBERS_ORDERED){
            if(!itemsOrdered.contains(media)){
                itemsOrdered.add(media);
                System.out.println("Added to cart successfully.");
                System.out.println("Quantity: " + itemsOrdered.size());
                if(itemsOrdered.size() >= MAX_NUMBERS_ORDERED - 2){
                    System.out.println("The cart is almost full.");
                }
            } else System.out.println("Media already exists in store.");
        } else System.out.println("The cart was full");
    }
    public void addMedia(Media...mediaList){
        for(Media media : mediaList){
            addMedia(media);
        }
    }
    public void removeMedia(Media media){
        if(itemsOrdered.remove(media)){
            System.out.println("The media has been removed.");
        }else System.out.println("The media was not found.");
    }
    public float totalCost() {
        float cost = 0;
        for (Media media : itemsOrdered) {
            cost += media.getCost();
        }
        return cost;
    }
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int i = 1;
        for (Media media : itemsOrdered) {
            System.out.println(i++ + ". " + media.toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }
    public void searchByTitle(String title){
        boolean found = false;
        for(Media media : itemsOrdered){
            if(media.getTitle().equalsIgnoreCase(title)){
                System.out.println(media.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No media found");
    }
    public Media searchTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
    public void searchById (int id){
        boolean found = false;
        for(Media media : itemsOrdered){
            if(media.getId() == id){
                System.out.println(media.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No media found");
    }
}
