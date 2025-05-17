package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add DVD");
        setJMenuBar(StoreManagerScreen.createMenuBar(this, store));

        JPanel form = new JPanel(new GridLayout(5, 2));
        JTextField titleField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField costField = new JTextField();
        JTextField directorField = new JTextField();
        JTextField lengthField = new JTextField();

        form.add(new JLabel("Title:")); form.add(titleField);
        form.add(new JLabel("Category:")); form.add(categoryField);
        form.add(new JLabel("Director:")); form.add(directorField);
        form.add(new JLabel("Length:")); form.add(lengthField);
        form.add(new JLabel("Cost:")); form.add(costField);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            DigitalVideoDisc dvd = new DigitalVideoDisc(
                    titleField.getText(),
                    categoryField.getText(),
                    directorField.getText(),
                    Integer.parseInt(lengthField.getText()),
                    Float.parseFloat(costField.getText())
            );
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(this, "DVD added!");
        });

        JPanel bottom = new JPanel();
        bottom.add(addButton);

        add(form, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
        setVisible(true);
    }
    @Override
    protected void addItem() {}
}
