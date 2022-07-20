import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
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
            System.out.println();
        }
        frame.remove(startMenu.getPanel());
        frame.repaint();
        frame.revalidate();
        game game = startMenu.getGame();
    }
}
