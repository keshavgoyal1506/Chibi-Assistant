package chibiassistant;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import chibiassistant.entity.Player;
public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;
    final int FPS = 60;

    KeyHandler input = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this,input);
    public GamePanel(){
        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setBackground(new Color(0, 0, 0, 0));
        this.setOpaque(true);
        this.setDoubleBuffered(true);
        this.addKeyListener(input);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run(){

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/drawInterval;
            lastTime = currentTime;
 
        if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update(){
        player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        player.draw(g2);
        g2.dispose();
    }
}
