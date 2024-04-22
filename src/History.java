import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


class History extends JFrame {
    JTextArea textarea;
    Font myFont = new Font("Arial", Font.BOLD, 15);

    History(ArrayList<String> calculation) {
        JFrame frame = new JFrame("Calculation History");
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());

        textarea = new JTextArea();
        textarea.setFont(myFont);
        JScrollPane scroll = new JScrollPane(textarea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        textarea.setEditable(false);
        frame.add(scroll, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton deleteButton = new JButton("Delete History");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(calculation.isEmpty()){
                    JOptionPane.showMessageDialog(null, "History is empty.", "Error", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the history?", "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        calculation.clear();
                        textarea.setText("");
                    }                    
                }
            }
        });
        buttonPanel.add(deleteButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        for (String calc : calculation) {
            textarea.append(calc + "\n");
        }
    }
}