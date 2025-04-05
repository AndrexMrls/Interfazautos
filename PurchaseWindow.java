
package com.mycompany.cardealerapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PurchaseWindow extends JFrame {
    
    // Constructor de la ventana de compra
    public PurchaseWindow(String selectedCar) {
        setTitle("Formulario de Compra");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Panel con GridLayout para organizar los componentes en filas y columnas
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10)); 
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margen alrededor del panel
        
        // Etiqueta que muestra el vehículo seleccionado
        panel.add(new JLabel("Vehículo seleccionado:"));
        panel.add(new JLabel(selectedCar));
        
        // Campo de texto para ingresar el nombre
        panel.add(new JLabel("Nombre:"));
        JTextField txtName = new JTextField();
        panel.add(txtName);
        
        // Campo de texto para ingresar el email
        panel.add(new JLabel("Email:"));
        JTextField txtEmail = new JTextField();
        panel.add(txtEmail);
        
        // Campo de texto para ingresar el teléfono
        panel.add(new JLabel("Teléfono:"));
        JTextField txtPhone = new JTextField();
        panel.add(txtPhone);
        
        // para seleccionar el método de pago
        panel.add(new JLabel("Método de pago:"));
        JComboBox<String> cmbPayment = new JComboBox<>(new String[]{"Efectivo", "Crédito", "Financiamiento"});
        panel.add(cmbPayment);
        
        // Botones de acción
        JButton btnBack = new JButton("Volver");
        JButton btnConfirm = new JButton("Confirmar");
        
        panel.add(btnBack);
        panel.add(btnConfirm);
        
        // Acción para volver al catálogo de vehículos
        btnBack.addActionListener((ActionEvent e) -> {
            new CatalogWindow().setVisible(true); // Abre la ventana del catálogo
            this.dispose(); // Cierra la ventana actual
        });
        
        // Acción para confirmar la compra con validación de campos
        btnConfirm.addActionListener((ActionEvent e) -> {
            if (txtName.getText().isEmpty() || txtEmail.getText().isEmpty()) {
                // Muestra un mensaje de error si los campos obligatorios están vacíos
                JOptionPane.showMessageDialog(this, "Complete todos los campos");
            } else {
                // Mensaje de confirmación con los datos ingresados
                JOptionPane.showMessageDialog(this, 
                    """
                    Compra confirmada
                    Veh\u00edculo: """ + selectedCar + "\n" +
                    "Cliente: " + txtName.getText() + "\n" +
                    "Nos contactaremos al: " + txtPhone.getText());
                
                new MainWindow().setVisible(true); 
                this.dispose();
            }
        });
        
        add(panel);
    }
}
