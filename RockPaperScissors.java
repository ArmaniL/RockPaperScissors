/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Armani Weise
 */
public class RockPaperScissors {

    JFrame mainwin;
    JPanel maindisplay;
    boolean ispicking=true,pressedgo=false,deciding=false;
    
    int width,height,scor=0,enscor=0,playerin=0,enemyin=0,index=0;
    JLabel score;
    JButton player,enemy,go;
    ImageIcon icons[]= new ImageIcon[3];
     public RockPaperScissors(int w,int h) throws InterruptedException{
    //varables initializations
   width=w;height=h;
    Dimension windowsize= new Dimension(width,height);
    icons[0]=new ImageIcon(new File("res\\rock.jpg").getAbsolutePath());
    icons[1]=new ImageIcon(new File("res\\paper.jpg").getAbsolutePath());
    icons[2]=new ImageIcon(new File("res\\scissors.jpg").getAbsolutePath());
  //Go button
  go= new JButton();
    go.setLocation(250,400);
    go.setSize(50, 20);
    go.addActionListener(new Play());
    go.setForeground(new Color(245,254,234));
    go.setBackground(new Color(120,40,18));
    go.setText("Go");
    
    //player button
    player= new JButton();
    player.setIcon(icons[0]);
    player.setLocation(w-200,176);
    player.setSize(165, 158);
    player.addActionListener(new Input());
    //enemy button
    enemy= new JButton();
    enemy.setIcon(icons[0]);
    enemy.setSize(165, 158);
    enemy.setLocation(10, 176);
    //Score label
    score=new JLabel();
    score.setFont(new Font("Verdana",Font.BOLD,12));
    score.setSize(300, 60);
    score.setLocation(0, 10);
//panel holding everthying
maindisplay= new JPanel();
maindisplay.setLayout(null);
maindisplay.setSize(windowsize);
maindisplay.setLocation(0, 0);
maindisplay.setBackground(new Color(247,80,36));
maindisplay.add(score);
maindisplay.add(player);
maindisplay.add(enemy);
maindisplay.add(go);
//window
    mainwin= new JFrame();
    mainwin.setMaximumSize(windowsize);
    mainwin.setMinimumSize(windowsize);
    mainwin.setSize(windowsize);
    mainwin.setDefaultCloseOperation(3);
    mainwin.setResizable(false);
    mainwin.setContentPane(maindisplay);
    mainwin.setVisible(true);
    
    while (true){
    //update
    if (pressedgo){
   if (enemyin<2) {enemyin++;}
   else {enemyin=0;}
    
   if (index<30){index++;}
   else {
       enemyin=(int)((Math.random()*90)/30);
       index=0;deciding=true;pressedgo=false;} 
    }
    
    if (deciding){
    if (((playerin>enemyin) && ( playerin>0))  &&    !((playerin==2) && (enemyin==0))      ){
    //win
    scor++;
    
    }
    else if (playerin==enemyin){}
    else {
    //lost
    enscor++;
    
    }
    deciding=false;
    pressedgo=false;
    ispicking=true;
    }
    
    
//draw
    player.setIcon(icons[playerin]);
    enemy.setIcon(icons[enemyin]);
    score.setText("You:"+Integer.toString(scor)+"Enemy:"+String.format("%10d",enscor));
   
    // time
Thread.sleep(50);
    }
    
    
    }
    
    
    public static void main(String[] args) throws InterruptedException {
        
        new RockPaperScissors(600,500);
    }
    
 class Input implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ispicking){
        if (playerin<2){playerin++;}
        else {playerin=0;}
        }
        }
}
    
 class Play implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
         ispicking=false;
            pressedgo=true;
        
        }
}
 


}
