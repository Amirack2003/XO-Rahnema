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
                        //checkTheWinner(i,j);
                        turn++;
                        setTurnColor();
                    }
                }
            }
        }
    };
    /*public void checkTheWinner(int x,int y){
        if( (x+1 < m && y+1 < m && field[x+1][y+1].getBackground().equals()) && ()){

        }
        else if(() && ()){

        }
        else if(() && ()){

        }
        else if(() && ()){

        }
    }*/
}
