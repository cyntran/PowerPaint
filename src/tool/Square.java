/*
 * TCSS 305 – Winter 2016 
 * Assignment 5b - PowerPaint
 * 
 */

package tool;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import model.DrawShape;


/**
 * 
 * This class draws a square. 
 * 
 * @author Cynthia Tran
 * @version 1
 *
 */
public class Square extends Rect {
    
    @Override
    public void draw(final Graphics theGraphics, final DrawShape theShape) {
        final int x = (int) theShape.getStartPoint().getX();
        final int y = (int) theShape.getStartPoint().getY();
        
        final int endX = (int) theShape.getEndPoint().getX();
        final int endY = (int) theShape.getEndPoint().getY();
        
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                             RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(theShape.getMyThick()));
        g2d.setColor(theShape.getMyColor());
        
        if (endX > x && endY > y) { 
            final int same = Math.max(endX - x, endY - y);
            drawTool(x, y, same, same, g2d); 
        } 
        
        if (endX < x && endY < y) {
            final int same = Math.max(x - endX, y - endY);
            drawTool(endX, endY, same, same, g2d);
        } 
        
        if (endX > x && endY < y) {
            final int same = Math.max(endX - x, y - endY);
            drawTool(x, endY, same, same, g2d);
        }
       
        if (endX < x && endY > y) {
            final int same = Math.max(x - endX, endY - y);
            drawTool(endX, y, same, same, g2d);
        }
        
    }

}
