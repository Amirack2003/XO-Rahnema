import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        frame.setSize(1200,800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        startMenu startMenu = new startMenu();
        frame.add(startMenu.getPanel());
        frame.repaint();
        frame.revalidate();
        boolean isReady = startMenu.getIs_game_ready();
        while (isReady == false){
            isReady = startMenu.getIs_game_ready();
            Thread.sleep(1000);
        }
        frame.remove(startMenu.getPanel());
        game game = startMenu.getGame();
        frame.setLayout(new GridLayout(2,1));
        frame.add(game.getMainpanel());
        frame.repaint();
        frame.revalidate();
    }
}
