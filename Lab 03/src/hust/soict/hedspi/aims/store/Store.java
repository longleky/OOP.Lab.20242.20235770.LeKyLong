package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Added to store: " + media.getTitle());
        } else {
            System.out.println("Media already exists in store.");
        }
    }
    public void addMedia(Media...mediaList){
        for(Media media : mediaList){
            addMedia(media);
        }
    }
    public void removeMedia(Media media){
        if(itemsInStore.remove(media)){
            System.out.println("The media has been removed.");
        }else System.out.println("The media was not found.");
    }
    public void printStore() {
        System.out.println("***************STORE***************");
        int i = 1;
        for (Media media : itemsInStore) {
            System.out.println(i++ + ". " + media.toString());
        }
        System.out.println("***********************************");
    }
    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
}
