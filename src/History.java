import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class History {
    
    JFrame frame = new JFrame();
    JLabel label;
    String calculation;

    public History(ArrayList<String> calculation){

        for(int i = 0; i < calculation.size(); i++){
            label = new JLabel(calculation.get(i));
        }
        label.setBounds(0, 0, 100, 50);
        label.setFont(new Font("Arial", Font.PLAIN, 25));

        
        frame.add(label);

        frame = new JFrame("History");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 700);
		frame.setLayout(null);
        frame.setVisible(true);


    }

    public void setCalculation(String calculation){
        this.calculation = calculation;
    }

    public String getCalculation(){
        return calculation;
    }


}
