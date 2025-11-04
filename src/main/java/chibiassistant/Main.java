package chibiassistant;
import javax.swing.JFrame;
import java.awt.Color;
public class Main{
    public static void main(String args[])
    {
        JFrame window = new JFrame();
        window.setUndecorated(true);
        window.setBackground(new Color(0, 0, 0, 0));
        window.setAlwaysOnTop(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Chibi Assistant");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}
