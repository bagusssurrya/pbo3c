package com.mycompany.pv1.basicForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Spotlight extends JPanel {
    private final int RADIUS = 50;
    private Image image;
    private int iw;
    private int ih;
    private int x;
    private int y;
    private boolean mouseIn;

    public Spotlight() {
        initComponents();
    }

    private void initComponents() {
        loadImage();
        
        if (image != null) { // Cek jika gambar berhasil dimuat
            iw = image.getWidth(null);
            ih = image.getHeight(null);
        }

        addMouseMotionListener(new MyMouseAdapter());
        addMouseListener(new MyMouseAdapter());
    }

    private void loadImage() {
        // Pastikan file image ada, jika tidak ada beri pesan kesalahan
        try {
            image = new ImageIcon("src/Images/photo.jpg").getImage();
            if (image == null) {
                throw new Exception("Image not found");
            }
        } catch (Exception e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        
        if (image != null) { // Gambar hanya jika image tersedia
            // Pusatkan gambar
            int midX = (getWidth() - iw) / 2;
            int midY = (getHeight() - ih) / 2;

            // Gambar gambar terlebih dahulu
            g2d.drawImage(image, midX, midY, iw, ih, this);
        }

        if (mouseIn) {
            // Gelapkan seluruh area di luar lingkaran spotlight
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f)); // Transparansi untuk efek gelap
            g2d.setPaint(Color.BLACK); // Warna hitam semi transparan
            g2d.fillRect(0, 0, getWidth(), getHeight()); // Gelapkan seluruh panel

            // Gambar spotlight untuk menyoroti area tertentu
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_OUT)); // Buat lingkaran yang memotong area gelap
            g2d.fillOval(x - RADIUS, y - RADIUS, RADIUS * 2, RADIUS * 2); // Gambar spotlight
        }

        g2d.dispose();
    }

    private class MyMouseAdapter extends MouseAdapter {

        @Override
        public void mouseExited(MouseEvent e) {
            if (mouseIn) { // Hanya repaint jika status mouse berubah
                mouseIn = false;
                repaint();
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (!mouseIn) { // Hanya repaint jika status mouse berubah
                mouseIn = true;
                repaint();
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            repaint();
        }
    }
}
