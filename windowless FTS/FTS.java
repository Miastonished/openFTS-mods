import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.image.*;
import java.awt.geom.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.Random;


public class FTS extends JFrame implements ActionListener{

    static BufferedImage bg = null;
    static BufferedImage egg = null;
    static BufferedImage bas = null;
    static BufferedImage sil = null;
    //  bg: background
    // egg: the three eggs
    // bas: basket of eggs
    // sil: silver!!!!!!
    
    static int scale = 2;
    // change the scale or whatever of the thingymajig (small = 1, don't set it to 0 that crashes it obviously lmfao, bigger sizes may be slower startup)
    
    static JFrame frame;
    static JButton hitbox;
    static JLabel silverImg;
    static JLabel bgImg;

    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    
    static Random rand = new Random();   
    static int r = rand.nextInt((int)screenSize.getHeight());
    static int r2 = rand.nextInt((int)screenSize.getWidth());
    
    
    public static void main(String[] args) {
        
        try {
            sil = ImageIO.read(new File("assets/silver.png"));
        } catch (IOException e) {
            System.out.println("Your goof is: damn "+e);
        }
        // ^ loads all the images
        
        
        frame = new JFrame("FTS UNLEEEEEEEEEEEEZHED!!");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setUndecorated(true);
        frame.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        frame.setVisible(true);
        // creates the window
        
        hitbox = new JButton(new ImageIcon(new ImageIcon(sil).getImage().getScaledInstance(100 * scale, 100 * scale, Image.SCALE_DEFAULT)));         
                frame.add(hitbox);
        hitbox.setBounds(r+(15 * scale),r2, 70 * scale,98 * scale);

        hitbox.setContentAreaFilled(false);
        hitbox.setBorderPainted(false);
        hitbox.addActionListener(new FTS());
        //makes the hitbox for silver
        
        silverImg = new JLabel();         
        silverImg.setBounds(r,r2,100 * scale,100 * scale);
        frame.add(silverImg); //   creates silver
        frame.revalidate();
        frame.setAlwaysOnTop(true); 
    }

    public void actionPerformed(ActionEvent e) {
        if(MouseInfo.getPointerInfo().getLocation().x >= hitbox.getLocationOnScreen().x && MouseInfo.getPointerInfo().getLocation().x <= hitbox.getLocationOnScreen().x + hitbox.getWidth() && MouseInfo.getPointerInfo().getLocation().y >= hitbox.getLocationOnScreen().y && MouseInfo.getPointerInfo().getLocation().y <= hitbox.getLocationOnScreen().y + hitbox.getHeight())
        {
            r = rand.nextInt(592 * scale);
            r2 = rand.nextInt(251 * scale);
            // ^ makes a new random value
            
            hitbox.setBounds(r+(15 * scale),r2, 70 * scale,98 * scale);
            silverImg.setBounds(r,r2,100 * scale,100 * scale);

            frame.revalidate();
            // ^ moves silver and silver's hitbox
        }
    }
    
}