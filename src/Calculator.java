import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.lang.Math;
import java.util.ArrayList;

public class Calculator implements ActionListener{


	ArrayList<String> calculation = new ArrayList<String>();
    JFrame frame;   
    JTextField textfield;   
    JButton[] numberButtons = new JButton[10];  
    JButton[] functionButtons = new JButton[10]; 
    JButton addButton,subButton,mulButton,divButton, sqrButton;    
    JButton decButton, equButton, delButton, clrButton, negButton;  
    JPanel panel;   

	History history;

	JButton historyButton;

    Font myFont = new Font("Arial",Font.BOLD,30);   

    double num1=0,num2=0,result=0;  
    char operator;

	

	Calculator(){

		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 700);
		frame.setLayout(null);
		textfield = new JTextField();
		textfield.setBounds(50, 25, 500, 100);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		historyButton = new JButton("History");
		historyButton.setFont(myFont);
		historyButton.setFocusable(false);
		historyButton.addActionListener(this);

	    addButton = new JButton("+");   
	    subButton = new JButton("-");   
	    mulButton = new JButton("*");   
	    divButton = new JButton("/");   
	    decButton = new JButton(".");   
	    equButton = new JButton("=");   
	    delButton = new JButton("Del"); 
	    clrButton = new JButton("Clr"); 
	    negButton = new JButton("(-)");

	    functionButtons[0] = addButton; 
	    functionButtons[1] = subButton; 
	    functionButtons[2] = mulButton; 
	    functionButtons[3] = divButton; 
	    functionButtons[4] = decButton; 
	    functionButtons[5] = equButton; 
	    functionButtons[6] = delButton; 
	    functionButtons[7] = clrButton; 
	    functionButtons[8] = negButton;

		

		for(int i =0;i<9;i++) { 
		    functionButtons[i].addActionListener(this); 
		    functionButtons[i].setFont(myFont); 
		    functionButtons[i].setFocusable(false);

		}

		

		for(int i =0;i<10;i++) {

		    numberButtons[i] = new JButton(String.valueOf(i));  
		    numberButtons[i].addActionListener(this);   
		    numberButtons[i].setFont(myFont);   
		    numberButtons[i].setFocusable(false);

		}
	
        negButton.setBounds(50,475,100,50);      
        delButton.setBounds(150,475,100,50);     
        clrButton.setBounds(250,475,100,50);
		historyButton.setBounds(350, 475, 200, 50);

		panel = new JPanel();
		panel.setBounds(50, 150, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));

	    panel.add(numberButtons[1]);    
	    panel.add(numberButtons[2]);    
	    panel.add(numberButtons[3]);    
	    panel.add(addButton);   
	    panel.add(numberButtons[4]);    
	    panel.add(numberButtons[5]);    
	    panel.add(numberButtons[6]);    
	    panel.add(subButton);   
	    panel.add(numberButtons[7]);    
	    panel.add(numberButtons[8]);    
	    panel.add(numberButtons[9]);    
	    panel.add(mulButton);   
	    panel.add(decButton);   
	    panel.add(numberButtons[0]);    
	    panel.add(equButton);   
	    panel.add(divButton);

		
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.add(historyButton);
		frame.setVisible(true);

	}

	

	public static void main(String[] args) {
		Calculator calc = new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == historyButton){
			history = new History(calculation);
		}

		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}

		if(e.getSource()==decButton) {
			textfield.setText(textfield.getText().concat("."));
		}

		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='+';
			textfield.setText("");
		}

		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='-';
			textfield.setText("");
		}

		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='*';
			textfield.setText("");
		}

		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='/';
			textfield.setText("");
		}

		if(e.getSource()==equButton) {
			num2=Double.parseDouble(textfield.getText());
			switch(operator) {
			case'+':
				result=num1+num2;
				setCalculation(num1, num2, result, operator);
				break;
			case'-':
				result=num1-num2;
				setCalculation(num1, num2, result, operator);
				break;
			case'*':
				result=num1*num2;
				setCalculation(num1, num2, result, operator);
				break;
			case'/':
				result=num1/num2;
				setCalculation(num1, num2, result, operator);
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}

		if(e.getSource()==clrButton) {
			textfield.setText("");
		}

		if(e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}

		if(e.getSource()==negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}


	}

	public void setCalculation(Double num1, Double num2, Double result, Character operator){
		switch(operator){
			case '+':
				calculation.add(""+num1+"+"+num2+"="+result+"");
				break;
			case '-':
				calculation.add(""+num1+"-"+num2+"="+result+"");
				break;
			case '*':
				calculation.add(""+num1+"*"+num2+"="+result+"");
				break;
			case '/':
				calculation.add(""+num1+"/"+num2+"="+result+"");
				break;
		}

		
	}

}

