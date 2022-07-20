import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class game {
    private JPanel fieldpanel = new JPanel(), mainpanel = new JPanel();
    private int turn = 0 , n , m;
    JButton field[][];
    Color colors[];
    JButton turn_color = new JButton();
    public game(int n,int m){
        this.n = n;
        this.m = m;
        field = new JButton[m][m];
        colors = new Color[n];
        fieldpanel.setLayout(new GridLayout(m,m));
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < m ;j++){
                field[i][j] = new JButton();
                field[i][j].setBackground(new Color(255,255,255));
                field[i][j].addActionListener(listener);
                fieldpanel.add(field[i][j]);
            }
        }
        Random random = new Random();
        for(int i = 0 ; i < n ; i++){
            int r = random.nextInt(175);
            int g = random.nextInt(175);
            int b = random.nextInt(175);
            colors[i] = new Color(r,g,b);
        }
        mainpanel.setLayout(new GridLayout(2,1));
        setTurnColor();
        mainpanel.add(turn_color);
        mainpanel.add(fieldpanel);
    }
    public void setTurnColor() {
        turn%=n;
        turn_color.setBackground(colors[turn]);
        turn_color.setText("Nobate Nafare : " + (turn+1));
    }
    public JPanel getMainpanel() {
        return mainpanel;
    }
    ActionListener listener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if (e.getSource() == field[i][j] && field[i][j].getBackground().equals(new Color(255, 255, 255)) ){
                        field[i][j].setBackground(colors[turn]);
                        turn++;
                        setTurnColor();
                        checkTheWinner();
                    }
                }
            }
        }
    };
    public void checkTheWinner(){
        for(int x = 1 ; x < m-1 ; x++) {
            for (int y = 1; y < m-1; y++) {
                for(int z = 0 ; z < n ; z++) {
                    if(!field[x][y].getBackground().equals(colors[z]))continue;
                    if (field[x + 1][y + 1].getBackground().equals(colors[z]) && field[x - 1][y - 1].getBackground().equals(colors[z])) {
                        JOptionPane.showMessageDialog(null, "Nafare " + (z+1) + " Barande Shod");
                        System.exit(0);
                    } else if (field[x - 1][y + 1].getBackground().equals(colors[z]) && field[x + 1][y - 1].getBackground().equals(colors[z])) {
                        JOptionPane.showMessageDialog(null, "Nafare " + (z+1) + " Barande Shod");
                        System.exit(0);
                    } else if (field[x][y + 1].getBackground().equals(colors[z]) && field[x][y - 1].getBackground().equals(colors[z])) {
                        JOptionPane.showMessageDialog(null, "Nafare " + (z+1) + " Barande Shod");
                        System.exit(0);
                    } else if (x + 1 < m && y < m && field[x + 1][y].getBackground().equals(colors[z]) && field[x - 1][y].getBackground().equals(colors[z])) {
                        JOptionPane.showMessageDialog(null, "Nafare " + (1+z) + " Barande Shod");
                        System.exit(0);
                    }
                }
            }
        }
    }
}
