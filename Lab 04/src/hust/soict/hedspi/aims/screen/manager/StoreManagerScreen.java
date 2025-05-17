package hust.soict.hedspi.aims.screen.manager;


import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame {
    private Store store;
    public StoreManagerScreen(Store store){
        setJMenuBar(StoreManagerScreen.createMenuBar(this, store));
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createHeader(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static JMenuBar createMenuBar(JFrame currentFrame, Store store) {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> {
            currentFrame.dispose();
            new StoreManagerScreen(store);
        });
        menu.add(viewStore);

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> {
            currentFrame.dispose();
            new AddBookToStoreScreen(store);
        });

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> {
            currentFrame.dispose();
            new AddCompactDiscToStoreScreen(store);
        });

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> {
            currentFrame.dispose();
            new AddDigitalVideoDiscToStoreScreen(store);
        });

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }
    JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }
    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < 9; i++) {
            if (i < mediaInStore.size()) {
                MediaStore cell = new MediaStore(mediaInStore.get(i));
                center.add(cell);
            } else {
                JPanel empty = new JPanel();
                center.add(empty);
            }
        }
        return center;
    }
    public static void main(String[] args) {
        Store store = new Store();
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
        store.addMedia(dvd1,dvd2,dvd3, dvd4, book1,book2,book3,cd1,cd2);
        new StoreManagerScreen(store);
    }
}
