public class DigitalVideoDisc {
    private String title;
    private String catelogy;
    private String director;
    private int length;
    private float cost;
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

    public DigitalVideoDisc(String title, String catelogy, String director, int length, float cost) {
        this.title = title;
        this.catelogy = catelogy;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
    public DigitalVideoDisc(String title, String catelogy, float cost){
        this.title = title;
        this.catelogy = catelogy;
        this.cost = cost;
    }
}
