package chibiassistant.entity;

import chibiassistant.GamePanel;
import chibiassistant.KeyHandler;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player extends Entity{
    GamePanel ca;
    KeyHandler input;
    public Player(GamePanel ca, KeyHandler input){
        this.ca = ca;
        this.input = input;
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

            up1 = ImageIO.read(getClass().getResourceAsStream("/other/player/chibi_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/other/player/chibi_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/other/player/chibi_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/other/player/chibi_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/other/player/chibi_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/other/player/chibi_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/other/player/chibi_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/other/player/chibi_right_2.png"));

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    boolean flag = false, flag2 = false;

    public void update() {
        if (input.cleanScreen & !flag2) {
            ca.setOpaque(flag);
            flag = !flag;
            flag2 = true;
        }
        
        if (!input.cleanScreen)flag2 = false;

        if (input.upPressed || input.downPressed || input.leftPressed || input.rightPressed)
            spriteCounter++;

        if (input.upPressed == true){
            direction = "up";
            y -= speed;
        }
        else if(input.downPressed == true){
            direction = "down";
            y += speed;
        }
        else if(input.leftPressed == true){
            direction = "left"; 
            x -= speed;
        }
        else if(input.rightPressed == true){
            direction = "right";
            x += speed;
        }
        if (spriteCounter >= 10){
            spriteNumber = !spriteNumber;
            spriteCounter = 0;
        }
        
    }

    public void draw(Graphics2D g2) {
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, ca.tileSize, ca.tileSize);
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
        g2.drawImage(image, x, y, ca.tileSize, ca.tileSize, null);
    }
}
