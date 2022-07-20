import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class startMenu {
    private JPanel panel , temp;
    JLabel number_of_player = new JLabel(), width_of_field = new JLabel();
    JTextField numberOfPlayer = new JTextField(), widthOfField = new JTextField();
    JButton start = new JButton();
    public startMenu(){
        panel = new JPanel();
        temp = new JPanel();
        panel.setLayout(new GridLayout(2,1));
        temp.setLayout(new GridLayout(2,2));
        number_of_player.setText("Tedad Bazikon ra vared konid");
        width_of_field.setText("Arz zamin bazi ra vared konid");
        start.setText("Shoro bazi");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        temp.add(number_of_player);
        temp.add(numberOfPlayer);
        temp.add(width_of_field);
        temp.add(widthOfField);
        panel.add(temp);
        panel.add(start);
    }
    public JPanel getPanel() {
        return panel;
    }
}
