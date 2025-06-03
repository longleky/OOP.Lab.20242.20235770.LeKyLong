package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book");
        setJMenuBar(StoreManagerScreen.createMenuBar(this, store));

        JPanel form = new JPanel(new GridLayout(4, 2));
        JTextField titleField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField costField = new JTextField();
        JTextArea authorsArea = new JTextArea(4, 20);

        form.add(new JLabel("Title:")); form.add(titleField);
        form.add(new JLabel("Category:")); form.add(categoryField);
        form.add(new JLabel("Cost:")); form.add(costField);
        form.add(new JLabel("Authors (1 per line):"));
        form.add(new JScrollPane(authorsArea));

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            Book book = new Book(titleField.getText(), categoryField.getText(), Float.parseFloat(costField.getText()));
            String[] authors = authorsArea.getText().split("\n");
            for (String author : authors) {
                book.addAuthor(author.trim());
            }
            store.addMedia(book);
            JOptionPane.showMessageDialog(this, "Book added to store!");
        });

        add(form, BorderLayout.CENTER);
        JPanel bottom = new JPanel();
        bottom.add(addButton);
        add(bottom, BorderLayout.SOUTH);
        setVisible(true);
    }
}