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
public class MijnComponent extends HComponent {
    private int br;
    private int ho;
    Image schipimg;
    Image sterrenimg;
    Image bulletimg;
    private int x;
    private int y,y2;
    MyBullet myBullet;
    
    

    public MijnComponent( int x, int y, int w, int h)
    {
        
    this.setBounds(x,y,w,h); //X,Y, breedte, hoogte
    br = w;
    ho = h;
    x = 0;
    y = 25;
    y2 = 0;
  myBullet = new MyBullet(this.x+80,this.y,"Player");
    
    schipimg = this.getToolkit().getImage("XWingFighter.png");
    sterrenimg = this.getToolkit().getImage("sterren.png");
    bulletimg = this.getToolkit().getImage("lazor.jpg");
    MediaTracker mt = new MediaTracker(this);
    mt.addImage(schipimg,0);
    mt.addImage(sterrenimg,0);
      mt.addImage(bulletimg,0);
 
    
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
      
    }
    public void paint(Graphics g)
    {
     g.drawImage(sterrenimg,y2+570,0,null);
     g.drawImage(sterrenimg,y2,0,null);
     g.drawImage(schipimg,this.x , this.y+250, null); //spwn ship in middle of screen
   
   

    }
    public void moveleft()
        {
            x-=5;
            this.repaint();
        
        }
    
    public void shoot()
        {
           myBullet = new MyBullet(this.x+80,this.y,"Player");
           
            System.out.println(myBullet);
             System.out.println(this);
            this.repaint();
        
        }
    
     public void moveright()
        {
            x+=5;
            this.repaint();
        
        }
      public void moveup()
        {
            y-=5;
            this.repaint();
            
        
        }
      public void movedown()
        {
            y+=5;
            this.repaint();
        
        }
      
       public void scroll()
        {
            y2-=5;
            this.repaint();
            
            if(y2 == -570)
            {
                
            y2=0;
            }
            
        
        }
       
        public void PlayerShoot()
        {
           //Schiet funcite om kogel te spawnen
            this.repaint();
            
            
            
        
        }
      
    
    
}
