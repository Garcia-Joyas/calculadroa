package calculadorabrandon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class CalculadoraBrandon extends JFrame implements ActionListener{

    private JTextField campoTexto;
    private JButton[] arrayNumeros;
    private JButton suma,resta,division,multiplicacion;
    private double UNO,DOS;
    private String operator;

    
    public CalculadoraBrandon(){
        Font font = new Font("Arial", Font.BOLD, 24);
        Font fontt = new Font("Arial", Font.BOLD, 30);

        
        setLayout(new BorderLayout());
        
        campoTexto = new JTextField();
        campoTexto.setEditable(true);
        campoTexto.setBackground(new Color(120,120,120));
        campoTexto.setPreferredSize(new Dimension(290, 70));
        campoTexto.setFont(fontt);
        add(campoTexto, BorderLayout.NORTH);
        
        
        suma = new JButton("+");
        suma.setFont(font);
        suma.addActionListener(this);
        suma.setBackground(Color.CYAN);
        resta = new JButton("-");
        resta.setFont(font);
        resta.addActionListener(this);
        resta.setBackground(Color.CYAN);
        division = new JButton("/");
        division.setFont(font);
        division.addActionListener(this);
        division.setBackground(Color.CYAN);
        multiplicacion = new JButton("*");
        multiplicacion.setFont(font);
        multiplicacion.addActionListener(this);
        multiplicacion.setBackground(Color.CYAN);

        
        JPanel botones = new JPanel(new GridLayout(1,4));
        botones.add(suma);
        botones.add(resta);
        botones.add(division);
        botones.add(multiplicacion);
        
        JPanel numeros = new JPanel(new GridLayout(4,3));
        arrayNumeros = new JButton[12];
        for(int i=0;i<12;i++){
            arrayNumeros[i] = new JButton(String.valueOf(i));
            arrayNumeros[i].addActionListener(this);
            arrayNumeros[i].setFont(font);
            arrayNumeros[i].setBackground(Color.BLACK);
            arrayNumeros[i].setForeground(Color.CYAN); 
            numeros.add(arrayNumeros[i]);

        }
        arrayNumeros[10].setText("C");
        arrayNumeros[11].setText("=");
        
        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.add(botones,BorderLayout.NORTH);    
        panelCentro.add(numeros,BorderLayout.CENTER);

        add(panelCentro,BorderLayout.CENTER);
        setTitle("Calculadora Brandon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
        setSize(300, 500);
        setBackground(Color.red);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraBrandon();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (isNumeric(command)) {
            campoTexto.setText(campoTexto.getText() + command);
        } else if (command.equals("+")) {
            UNO = Double.parseDouble(campoTexto.getText());
            operator = "+";
            campoTexto.setText("");
        } else if (command.equals("-")) {
            UNO = Double.parseDouble(campoTexto.getText());
            operator = "-";
            campoTexto.setText("");
        } else if (command.equals("/")) {
            UNO = Double.parseDouble(campoTexto.getText());
            operator = "/";
            campoTexto.setText("");
        } else if (command.equals("*")) {
            UNO = Double.parseDouble(campoTexto.getText());
            operator = "*";
            campoTexto.setText("");
        } else if (command.equals("C")) {
            campoTexto.setText("");
        } else if (command.equals("=")) {
            DOS = Double.parseDouble(campoTexto.getText());
            double result = 0;

            if (operator.equals("+")) {
                result = UNO + DOS;
            } else if (operator.equals("-")) {
                result = UNO - DOS;
            } else if (operator.equals("/")) {
                result = UNO / DOS;
            } else if (operator.equals("*")) {
                result = UNO  * DOS;
            }

            campoTexto.setText(String.valueOf(result));
        }
    }
    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}