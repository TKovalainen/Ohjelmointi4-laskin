import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class History {
    
    JFrame frame = new JFrame();
    JLabel label = new JLabel("1+1 = 3");

    public History(){

        label.setBounds(0, 0, 100, 50);
        label.setFont(new Font("Arial", Font.PLAIN, 25));

        frame.add(label);
        
        frame = new JFrame("History");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 700);
		frame.setLayout(null);
        frame.setVisible(true);


    }


}
