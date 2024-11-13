/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pv1.basicForm;

import javax.swing.JFrame;
import java.awt.EventQueue;

/**
 *
 * @author bagus
 */
public class FrameDemo extends JFrame {
    public FrameDemo() {
        // Mengatur judul form
        setTitle("Frame Demo");
        // Mengatur tombol close di jendela akan menutup program
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Mengatur ukuran form
        setSize(300, 200);
    }

    public static void main(String[] args) {
        // Menjalankan dan menampilkan form
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameDemo().setVisible(true);
            }
        });
    }
}
