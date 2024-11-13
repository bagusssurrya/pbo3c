package com.mycompany.pv1.basicForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComponentDemo extends JFrame {

    public ComponentDemo() {
        // Mengatur judul form
        setTitle("Component Demo");
        // Tombol Close pada jendela diatur menutup program jika diklik
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Mengatur ukuran form
        setSize(300, 200);
        // Memanggil fungsi menambahkan komponen ke form
        initComponents();
    }

    private void initComponents() {
        // Membuat label dari JLabel
        JLabel lblPesan = new JLabel();
        // Variabel untuk menampung pesan
        String pesan = "<html><font color=\"blue\"><big>Java</big></font>" + 
                       "<sup>TM</sup> &copy; <em>Oracle Corporation</em>.<br>" +
                       "<font color=\"red\">Hak Cipta Dilindungi oleh UU.</font></html>";
        // Label menampilkan pesan
        lblPesan.setText(pesan);

        // Membuat tombol Quit dari JButton
        JButton btnKeluar = new JButton("Keluar");
        // Menambahkan fungsi menutup program pada tombol Quit
        btnKeluar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Menutup program
            }
        });

        // Mengatur letak label dan button pada form
        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);
        gl.setAutoCreateContainerGaps(true);
        gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(lblPesan)
                .addComponent(btnKeluar));
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(lblPesan)
                .addComponent(btnKeluar));
    }

    public static void main(String[] args) {
        // Menjalankan dan menampilkan form
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComponentDemo().setVisible(true);
            }
        });
    }
}
