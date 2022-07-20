import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class game {
    private JPanel fieldpanel = new JPanel(), mainpanel = new JPanel();
    private int turn = 0 , n;
    JButton field[][];
    Color colors[];
    JButton turn_color = new JButton();
    public game(int n,int m){
        this.n = n;
        field = new JButton[m][m];
        colors = new Color[n];
        fieldpanel.setLayout(new GridLayout(m,m));
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < m ;j++){
                field[i][j] = new JButton();
                field[i][j].setBackground(new Color(255,255,255));
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
}
