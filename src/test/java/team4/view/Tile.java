package view;

import javax.swing.*;
import java.awt.*;

public class Tile extends JComponent{

    private int value;
    private int width;
    private int height;

    public Tile(int value){
        this.value = value;
        this.setPreferredSize(new Dimension(100, 100));
    }

    public int getValue(){
        return this.value;
    }

    public void setValue(int value){
        this.value = value;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        width = getWidth();
        height = getHeight();
        g.setColor(new Color(123, 120, 109));
        g.fillRect(0, 0, width, height);

        switch(this.value){
            case 2: g.setColor(new Color(245, 241, 226));
                    break;
            case 4: g.setColor(new Color(236, 230, 174));
                    break;
            case 8: g.setColor(new Color(237, 190, 131));
                    break;
            case 16: g.setColor(new Color(252, 163, 50));
                    break;
            case 32: g.setColor(new Color(255, 158, 108));
                    break;
            case 64: g.setColor(new Color(255, 122, 81));
                    break;
            case 128: g.setColor(new Color(225, 215, 115));
                    break;
            case 256: g.setColor(new Color(222, 210, 81));
                    break;
            case 512: g.setColor(new Color(227, 212, 45));
                    break;
            case 1024: g.setColor(new Color(227, 212, 45));
                    break;
            case 2048: g.setColor(new Color(228, 207, 0));
                    break;
            default: g.setColor(new Color(204, 193, 180));
                    break;
        }
        
        g.fillRoundRect(5, 5, width-10, height-10, 40, 40);
        
        g.setColor(Color.white);
        g.drawString(Integer.toString(value), width/2, height/2);
        
    }
}
