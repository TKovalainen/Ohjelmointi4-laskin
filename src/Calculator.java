import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator {
    
    JFrame frame;
    JButton[] numbers = new JButton[10];
    JTextField textField;
    JPanel panel;
    Font font = new Font("Arial", Font.BOLD, 30);

    public Calculator(){

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 800);
        frame.setLayout(null);

        frame.setVisible(true);
    }

    public static void main(String[] args){

        Calculator calculator = new Calculator();
    }
}
