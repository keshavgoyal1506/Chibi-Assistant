package main;
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
        window.setTitle("2D Adventure");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}