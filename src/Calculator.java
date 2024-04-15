import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener{
    
    JFrame frame;
    JButton[] numbers = new JButton[10];
    JButton[] functions = new JButton[9];
    JButton addButton, subButton, mulButton, divButton, sqrtButton, potenssiButton, piButton;
    JButton decButton, equalsButton, delButton, clearButton, negButton;
    JTextField textField;
    JPanel panel;
    Font font = new Font("Ink Free", Font.BOLD, 30);
    double num1=0, num2=0, result=0;
    char operator;

    public Calculator(){

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);

        textField.setFont(font);
        textField.setEditable(true);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(",");
        equalsButton = new JButton("=");
        delButton = new JButton("<-");
        clearButton = new JButton("Clr");
        negButton = new JButton("(-)");

        functions[0] = addButton;
		functions[1] = subButton;
		functions[2] = mulButton;
		functions[3] = divButton;
		functions[4] = decButton;
		functions[5] = equalsButton;
		functions[6] = delButton;
		functions[7] = clearButton;
		functions[8] = negButton;

        for(int i = 0; i < 9; i++){
            functions[i].addActionListener(this);
            functions[i].setFont(font);
            functions[i].setFocusable(false);
        }

        for(int i = 0; i < 10; i++){
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(font);
            numbers[i].setFocusable(false);
        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clearButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(addButton);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(subButton);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numbers[0]);
        panel.add(equalsButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clearButton);

        panel.add(textField);

        frame.setVisible(true);
    }

    public static void main(String[] args){

        Calculator calculator = new Calculator();


    }

@Override

	public void actionPerformed(ActionEvent e) {

	
		for(int i=0;i<10;i++) {
			if(e.getSource() == numbers[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decButton) {
			textField.setText(textField.getText().concat(","));
		}
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textField.getText());
			operator ='+';
			textField.setText("");
		}

		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textField.getText());
			operator ='-';
			textField.setText("");
		}

		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textField.getText());
			operator ='*';
			textField.setText("");
		}

		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textField.getText());
			operator ='/';
			textField.setText("");
		}

		if(e.getSource()==equalsButton) {
			num2=Double.parseDouble(textField.getText());
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			textField.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clearButton) {
			textField.setText("");
		}
		if(e.getSource()==delButton) {
			String string = textField.getText();
			textField.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textField.setText(textField.getText()+string.charAt(i));
			}

		}

		if(e.getSource()==negButton) {
			double temp = Double.parseDouble(textField.getText());
			temp*=-1;
			textField.setText(String.valueOf(temp));
		}

	}

}

