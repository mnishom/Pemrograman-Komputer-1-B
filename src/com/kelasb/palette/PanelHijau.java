/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kelasb.palette;

/**
 *
 * @author ISOM
 */

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
 
 /**
 *
 * @author isom
 */
public final class PanelHijau extends JPanel
 {
   private Color colorAbove;
   private Color colorBelow;
 
   public PanelHijau()
   {
     setOpaque(false);
     setColorAbove(new Color(0, 102, 0)); 
     setColorBelow(new Color(102, 204, 0));
   }
 
   public Color getColorAbove() {
     return this.colorAbove;
   }
 
   public void setColorAbove(Color colorAbove) {
    this.colorAbove = colorAbove;
    repaint();
   }
 
   public Color getColorBelow() {
     return this.colorBelow;
   }
 
   public void setColorBelow(Color colorBelow) {
     this.colorBelow = colorBelow;
    repaint();
   }
 
     @Override
   protected void paintComponent(Graphics g)
   {
     super.paintComponent(g);
     Graphics2D gd = (Graphics2D)g.create();
     gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_DEFAULT);
     gd.setPaint(new GradientPaint(0.0F, 0.0F, getColorAbove(), 0.0F, getHeight(), getColorBelow()));
     gd.fillRoundRect(0, 0, getWidth(), getHeight(),25,25);
     gd.setPaint(new GradientPaint(0.0F, 0.0F, new Color(255, 255, 255, 120), 0.0F, 50.0F, new Color(0, 0, 0, 0)));
     gd.fillRoundRect(0, 0, getWidth(), 50,25,25);
     gd.dispose();
   }
 }
