package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "Add CD");
        setJMenuBar(StoreManagerScreen.createMenuBar(this, store));

        JPanel form = new JPanel(new GridLayout(6, 2));
        JTextField titleField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField artistField = new JTextField();
        JTextField directorField = new JTextField();
        JTextField costField = new JTextField();
        JTextArea trackListArea = new JTextArea(4, 20);

        form.add(new JLabel("Title:")); form.add(titleField);
        form.add(new JLabel("Category:")); form.add(categoryField);
        form.add(new JLabel("Artist:")); form.add(artistField);
        form.add(new JLabel("Director:")); form.add(directorField);
        form.add(new JLabel("Cost:")); form.add(costField);
        form.add(new JLabel("Tracks (title-length per line, separated by '-'):"));
        form.add(new JScrollPane(trackListArea));

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            CompactDisc cd = new CompactDisc(
                    titleField.getText(),
                    categoryField.getText(),
                    directorField.getText(),
                    Float.parseFloat(costField.getText()),
                    artistField.getText()
            );

            String[] lines = trackListArea.getText().split("\n");
            for (String line : lines) {
                String[] parts = line.split("-");
                if (parts.length == 2) {
                    String trackTitle = parts[0].trim();
                    int length = Integer.parseInt(parts[1].trim());
                    cd.addTrack(new Track(trackTitle, length));
                }
            }

            store.addMedia(cd);
            JOptionPane.showMessageDialog(this, "CD added to store!");
        });

        add(form, BorderLayout.CENTER);
        JPanel bottom = new JPanel();
        bottom.add(addButton);
        add(bottom, BorderLayout.SOUTH);
        setVisible(true);
    }

    @Override
    protected void addItem() {}
}