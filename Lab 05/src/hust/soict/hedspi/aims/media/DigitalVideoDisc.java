package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;
    public DigitalVideoDisc(String title) {
        super(title);
        setId(++nbDigitalVideoDiscs);
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title,category,director,length,cost);
        setId(++nbDigitalVideoDiscs);
    }
    public DigitalVideoDisc(String title, String category, float cost){
        super(title, category, cost);
        setId(++nbDigitalVideoDiscs);
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title,category,director,cost);
        setId(++nbDigitalVideoDiscs);
    }
    public String toString(){
        return "DVD" + getId() + " - [" + getTitle() + "] - [" + getCategory() + "] - [" + getDirector() + "] - [" + getLength() + "]: " + getCost() + " $";
    }
    public void play() {
        if (this.getLength() > 0){
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else{
            System.out.println("This DVD cannot be played.");
        }
    }
}
