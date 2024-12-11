package fff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {

    public static double suma(double num1, double num2) {
        return num1 + num2;
    }

    public static double resta(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiplicacion(double num1, double num2) {
        return num1 * num2;
    }

    public static double division(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("División por cero no permitida.");
        }
        return num1 / num2;
    }

    public static void main(String[] args) {
      
        JFrame frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 350);
        frame.setLayout(new GridLayout(4, 3));

     
        JLabel label1 = new JLabel("Primer número:");
        JTextField text1 = new JTextField();

        JLabel label2 = new JLabel("Segundo número:");
        JTextField text2 = new JTextField();

        JLabel labelResult = new JLabel("Resultado:");
        JTextField textResult = new JTextField();
        textResult.setEditable(false);

        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Suma", "Resta", "Multiplicación", "División"});

        JButton calcularButton = new JButton("Calcular");
        

    
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(text1.getText());
                    double num2 = Double.parseDouble(text2.getText());
                    double resultado = 0;

                    String operacion = (String) comboBox.getSelectedItem();
                    switch (operacion) {
                        case "Suma":
                            resultado = suma(num1, num2);
                            break;
                        case "Resta":
                            resultado = resta(num1, num2);
                            break;
                        case "Multiplicación":
                            resultado = multiplicacion(num1, num2);
                            break;
                        case "División":
                            resultado = division(num1, num2);
                            break;
                    }

                    textResult.setText(String.valueOf(resultado));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, introduce números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

       
      

   
        frame.add(label1);
        frame.add(text1);
        frame.add(label2);
        frame.add(text2);
        frame.add(comboBox);
        frame.add(calcularButton);
        frame.add(labelResult);
        frame.add(textResult);
        
        
        frame.setVisible(true);
    }
}