public class DigitalVideoDisc {
    private String title;
    private String catelogy;
    private String director;
    private int length;
    private float cost;

    private static int nbDigitalVideoDiscs = 0;
    private int id;
    public int getId(){
        return id;
    }
    public float getCost() {
        return cost;
    }

    public String getTitle() {
        return title;
    }

    public String getCatelogy() {
        return catelogy;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }
    public DigitalVideoDisc(String title) {
        this.title = title;
        this.id = ++nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String title, String catelogy, String director, int length, float cost) {
        this.title = title;
        this.catelogy = catelogy;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String title, String catelogy, float cost){
        this.title = title;
        this.catelogy = catelogy;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String title, String catelogy, String director, float cost) {
        this.title = title;
        this.catelogy = catelogy;
        this.director = director;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }
}
