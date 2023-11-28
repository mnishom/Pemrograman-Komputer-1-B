package com.kelasb.palette;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.Timer;

/**
 *
 * @author isom
 */
public final class ButtonPurple extends JButton
  implements ActionListener
{
  private boolean enter;
  private boolean press;
  private int alpha = 10; private int alpha2 = 80;
  private int speed;
  private final Timer timer;
  private final Timer timer2;

  public ButtonPurple()
  {
     setOpaque(false);
     setContentAreaFilled(false);
     setFocusPainted(false);
     setBorderPainted(false);
     setForeground(Color.white);
     setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR)); 
     setSpeed(10);

     this.timer = new Timer(10, this);
     this.timer2 = new Timer(10, this);

     addMouseListener(new MouseAdapter()
    {
        @Override
      public void mousePressed(MouseEvent e)
      {
        ButtonPurple.this.setPress(true);
      }

        @Override
      public void mouseReleased(MouseEvent e)
      {
         ButtonPurple.this.setPress(false);
      }

        @Override
      public void mouseEntered(MouseEvent e)
      {
         ButtonPurple.this.setEnter(true);
      }

        @Override
      public void mouseExited(MouseEvent e)
      {
         ButtonPurple.this.setEnter(false);
      }
    });
  }
  
  public ButtonPurple(String title)
  {
     super(title);
     setOpaque(false);
     setContentAreaFilled(false);
     setFocusPainted(false);
     setBorderPainted(false);
     setForeground(Color.white);
     setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR)); 
     setSpeed(10);

     this.timer = new Timer(10, this);
     this.timer2 = new Timer(10, this);

     addMouseListener(new MouseAdapter()
    {
        @Override
      public void mousePressed(MouseEvent e)
      {
        ButtonPurple.this.setPress(true);
      }

        @Override
      public void mouseReleased(MouseEvent e)
      {
         ButtonPurple.this.setPress(false);
      }

        @Override
      public void mouseEntered(MouseEvent e)
      {
         ButtonPurple.this.setEnter(true);
      }

        @Override
      public void mouseExited(MouseEvent e)
      {
         ButtonPurple.this.setEnter(false);
      }
    });
  }

  public boolean isEnter() {
    return this.enter;
  }

  public void setEnter(boolean enter) {
    this.enter = enter;
    repaint();
  }

  public boolean isPress() {
    return this.press;
  }

  public void setPress(boolean press) {
    this.press = press;
    repaint();
  }

  public int getSpeed() {
    return this.speed;
  }

  public void setSpeed(int speed)
  {
     if (speed > 10) {
      speed = 10;
    }
    this.speed = speed;
  }

    @Override
  protected void paintComponent(Graphics g)
  {
    Graphics2D gd = (Graphics2D)g.create();
     gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
     if (isEnabled()) {
       if (isEnter()) {
         this.alpha2 = 160;
         gd.setPaint(new GradientPaint(0.0F, 0.0F, new Color(0, 255, 0), 0.0F, getHeight(), new Color(0, 204, 0)));
         gd.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
         gd.setColor(new Color(255, 255, 255, this.alpha));
         gd.fillRoundRect(0, 0, getWidth(), getHeight() / 2, 10, 10);
         if (isPress()) {
           gd.setPaint(new GradientPaint(0.0F, 0.0F, new Color(0, 0, 0, 80), 0.0F, getHeight(), new Color(0, 0, 0, 80)));
           gd.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
        }
         this.timer.start();
      } else {
         this.alpha = 10;
         gd.setPaint(new GradientPaint(0.0F, 0.0F, new Color(144, 12, 63), 0.0F, getHeight(), new Color(199, 0, 57).brighter()));
         gd.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
         gd.setColor(new Color(255, 255, 255, this.alpha2));
         gd.fillRoundRect(0, 0, getWidth(), getHeight() / 2, 10, 10);
         this.timer2.start();
      }
    } else {
       gd.setPaint(new GradientPaint(0.0F, 0.0F, new Color(144, 12, 63), 0.0F, getHeight(), new Color(199, 0, 57)));
       gd.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
       gd.setColor(new Color(255, 255, 255, 50));
       gd.fillRoundRect(0, 0, getWidth(), getHeight() / 2, 10, 10);
    }
     gd.dispose();
     super.paintComponent(g);
  }

    @Override
  public void actionPerformed(ActionEvent e) {
     if (e.getSource() == this.timer) {
       this.alpha += getSpeed();
       if (this.alpha >= 120) {
         this.alpha = 120;
         this.timer.stop();
      }
       repaint();
     } else if (e.getSource() == this.timer2) {
       this.alpha2 -= getSpeed();
       if (this.alpha2 <= 80) {
         this.alpha2 = 80;
         this.timer2.stop();
      }
       repaint();
    }
  }
}