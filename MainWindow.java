package com.mycompany.cardealerapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {
    
    // Constructor de la ventana principal
    public MainWindow() {
        setTitle("Concesionario de Autos");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        
        JLabel title = new JLabel("Andrés Morales Motors !!Pasión por los Autos¡¡", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        
        JButton btnCatalog = new JButton("Ver Catálogo De Vehiculos");
        JButton btnExit = new JButton("Salir");
        
        panel.add(title);
        panel.add(btnCatalog);
        panel.add(btnExit);
        
        btnCatalog.addActionListener((ActionEvent e) -> {
            new CatalogWindow().setVisible(true);
            this.dispose();
        });
        
        btnExit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        
        add(panel);
    }
}