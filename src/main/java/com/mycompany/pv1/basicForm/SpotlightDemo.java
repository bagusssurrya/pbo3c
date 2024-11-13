package com.mycompany.pv1.basicForm;

import javax.swing.*;
import java.awt.*;

public class SpotlightDemo extends JFrame {
    public SpotlightDemo() {
        initComponents();
    }

    private void initComponents() {
        add(new Spotlight()); 
        setTitle("Spotlight Demo");
        setSize(350, 300);
        setLocationRelativeTo(null);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                SpotlightDemo spotlightDemo = new SpotlightDemo();
                spotlightDemo.setVisible(true);  
            } catch (Exception e) {
                e.printStackTrace();  
            }
        });
    }
}
