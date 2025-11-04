package entity;

import main.GamePanel;
import main.KeyHandler;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){
        try{

            up1 = ImageIO.read(getClass().getResourceAsStream("/player/chibi_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/chibi_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/chibi_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/chibi_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/chibi_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/chibi_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/chibi_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/chibi_right_2.png"));

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
	
	boolean flag = false, flag2 = false;

    public void update() {
		if (keyH.cleanScreen & !flag2) {
			gp.setOpaque(flag);
			flag = !flag;
			flag2 = true;
		}
		
		if (!keyH.cleanScreen)flag2 = false;

        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed)
            spriteCounter++;

        if (keyH.upPressed == true){
            direction = "up";
            y -= speed;
        }
        else if(keyH.downPressed == true){
            direction = "down";
            y += speed;
        }
        else if(keyH.leftPressed == true){
            direction = "left"; 
            x -= speed;
        }
        else if(keyH.rightPressed == true){
            direction = "right";
            x += speed;
        }
        if (spriteCounter >= 10){
            spriteNumber = !spriteNumber;
            spriteCounter = 0;
        }
        
    }

    public void draw(Graphics2D g2) {
//		g2.setColor(Color.white);
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        BufferedImage image = null;
        switch(direction){
            case "up":
                if (spriteNumber)image = up1;
                else image = up2;
                break;
            case "down":
                if (spriteNumber)image = down1;
                else image = down2;
                break;
            case "right":
                if (spriteNumber)image = right1;
                else image = right2;
                break;
            case "left":
                if (spriteNumber)image = left1;
                else image = left2;
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}