package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book extends Media{
    private static int nbBooks = 0;
    private ArrayList<String> authors = new ArrayList<>();
    public Book(String title, String category, float cost){
        super(title,category,cost);
        setId(++nbBooks);
    }
    public void addAuthor(String authorName){
        if(authors.contains(authorName)){
            System.out.println("Already added");
        }
        else{
            authors.add(authorName);
        }
    }
    public void removeAuthor(String authorName){
        if(authors.remove(authorName)){
            System.out.println("Author removed.");
        }
        else{
            System.out.println("Not found.");
        }
    }
    public String toString() {
        return "Book" + getId() + " - [" + getTitle() + "] - [" + getCategory() + "] - Authors: " + authors + ": " + getCost() + " $";
    }
}
