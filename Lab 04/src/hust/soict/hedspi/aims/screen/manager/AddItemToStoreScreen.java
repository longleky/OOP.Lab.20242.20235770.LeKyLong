package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    public AddItemToStoreScreen(Store store, String title) {
        this.store = store;
        setTitle(title);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        add(createHeader(), BorderLayout.NORTH);
    }

    protected JPanel createHeader() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel(getTitle());
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(label);
        return panel;
    }

    protected abstract void addItem();
}
