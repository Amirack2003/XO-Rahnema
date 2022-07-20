import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class game {
    JPanel fieldpanel = new JPanel(), mainpanel = new JPanel();
    JButton field[][];
    Color colors[];
    int turn = 0;
    public game(int n,int m){
        field = new JButton[m][m];
        fieldpanel.setLayout(new GridLayout(m,m));
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < m ;j++){
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
    }
}
