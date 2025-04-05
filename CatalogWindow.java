package com.mycompany.cardealerapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CatalogWindow extends JFrame {
    
    private final String[] cars = {
        "Toyota Corolla - $25,000",
        "Honda Civic - $27,000", 
        "Ford Mustang - $45,000",
        "Chevrolet Tahoe - $55,000",
        "Tesla Model 3 - $42,000",  
        "BMW X5 - $65,000",        
        "Nissan Sentra - $22,300",  
        "Audi Q7 - $68,400"   
     
        
    };
    
    public CatalogWindow() {
        setTitle("Catálogo de Vehículos - Andrés Morales Motors"); 
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JList<String> list = new JList<>(cars);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setFont(new Font("Arial", Font.PLAIN, 14));
        
        // Botones
        JButton btnBack = new JButton("Volver al Menú");
        JButton btnBuy = new JButton("Comprar Vehículo");
        btnBuy.setBackground(new Color(0, 102, 204));
        btnBuy.setForeground(Color.WHITE);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(btnBack);
        buttonPanel.add(btnBuy);
        
        panel.add(new JScrollPane(list), BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Acción para volver
        btnBack.addActionListener((ActionEvent e) -> {
            new MainWindow().setVisible(true);
            this.dispose();
        });
        
        // Acción para comprar CON VALIDACIÓN MEJORADA
        btnBuy.addActionListener((ActionEvent e) -> {
            try {
                int selectedIndex = list.getSelectedIndex();
                if(selectedIndex >= 0 && selectedIndex < cars.length) {
                    new PurchaseWindow(cars[selectedIndex]).setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "Seleccione un vehículo de la lista", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(this, 
                    "Error al procesar la selección: " + ex.getMessage(), 
                    "Error crítico", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });
        
        add(panel);
    }
}