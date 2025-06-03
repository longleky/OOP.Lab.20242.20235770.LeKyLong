package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private static int nbCompactDiscs = 0;
    private ArrayList<Track> tracks = new ArrayList<>();
    public String getArtist() {
        return artist;
    }
    public CompactDisc(String title, String category, String director, float cost, String artist){
        super(title,category,director,cost);
        this.artist = artist;
        setId(++nbCompactDiscs);
    }
    public void addTrack(Track track){
        if(tracks.contains(track)){
            System.out.println("Track already exists in CD.");
        } else {
            tracks.add(track);
        }
    }
    public void removeTrack(Track track){
        if(tracks.remove(track)){
            System.out.println("The track has been removed.");
        }else System.out.println("The track was not found.");
    }
    public int getLength(){
        int length = 0;
        for(Track track : tracks){
            length += track.getLength();
        }
        return length;
    }
    public void play() {
        if(getLength() > 0){
            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("CD category: " + this.getCategory());
            System.out.println("CD director: " + this.getDirector());
            System.out.println("CD cost: " + this.getCost());
            System.out.println("CD artist: " + this.getArtist());
            System.out.println("CD length: " + this.getLength());
            for(Track tr : tracks){
                tr.play();
            }
        } else{
            System.out.println("This CD cannot be played.");
        }
    }
    public String toString() {
        return "CD" + getId() + " - [" + getTitle() + "] - [" + getCategory() + "] - [" + getDirector() + "] - [" + artist + "] - [" + getLength() + "]: " + getCost() + " $";
    }
}
