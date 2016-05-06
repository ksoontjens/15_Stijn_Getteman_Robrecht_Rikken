/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;

/**
 *
 * @author RobrechtRikken
 */
public class MyBullet extends HComponent {
    private int br;
    private int ho;
    String bulletFrom;
    Image bulletimg;
    int x, y, bulletSpeed;
    
    public MyBullet( int initX, int initY, String bulletFrom)
    {
    br = 40;
    ho = 40;
    x = initX;
    y = initY;
    this.setBounds(x,y,br,ho); //X,Y, breedte, hoogte
   this.bulletFrom = bulletFrom;
    bulletSpeed = 1;
   
   //kijken wie bulletFrom, if enemy dan enmy bullet en player dan player bullet
    bulletimg = this.getToolkit().getImage("lazor.jpg");
    
    MediaTracker mt = new MediaTracker(this);
    mt.addImage(bulletimg, 0);
    
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    
    }
    public void paint(Graphics g)
    {
        g.drawImage(bulletimg, x+50,y,null);
   //System.out.println("DRAWBULLET");
    
    }
    /* public void callBack()
    {
        if(bulletFrom=="Player")
        {
           moveright();
        }

        if(bulletFrom=="Enemy")
        {
            moveleft();
        }
        
    }*/
    public void moveleft()
        {
            x-=bulletSpeed;
            this.repaint();
        
        }
    
   
     public void moveright()
        {
            x+=bulletSpeed;
            this.repaint();
        
        }
  
    
    
}
