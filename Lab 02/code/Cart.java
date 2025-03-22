public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    public void addDigitalVideoDisc (DigitalVideoDisc disc){
        if(qtyOrdered < 20){
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered ++;
            System.out.println("The disc has been added.");
        } else{
            System.out.println("The cart is almost full");
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList){
        for(DigitalVideoDisc dvd : dvdList){
            addDigitalVideoDisc(dvd);
        }
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        boolean found = false;
        for (int i = 0;i<qtyOrdered;i++){
            if(itemsOrdered[i]==disc){
                found = true;
                for (int j =i;j<qtyOrdered;j++){
                    itemsOrdered[j]=itemsOrdered[j+1];
                }
                qtyOrdered--;
                System.out.println("The disc has been removed.");
                break;
            }
        }
        if(!found){
            System.out.println("The disc was not found.");
        }
    }
    public float totalCost(){
        float total = 0;
        for (int i = 0;i<qtyOrdered;i++){
            total += itemsOrdered[i].getCost();
        }
        return total;
    }public void displayCard(){
        System.out.println("Cast Items:");
        for (int i = 0; i<qtyOrdered;i++){
            System.out.println((i+1) + "\t" + itemsOrdered[i].getTitle() + "\t" + itemsOrdered[i].getCost());
        }
        System.out.println("Total Cost: \t" + totalCost());
    }
}
