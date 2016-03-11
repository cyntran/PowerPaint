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
 * This class draws a rectangle. 
 * 
 * @author Cynthia Tran
 * @version 1
 */
public class Rect extends AbstractTool {
   

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
            drawTool(x, y, endX - x, endY - y, g2d); 
        } 
        
        if (endX < x && endY < y) {
            drawTool(endX, endY, x - endX, y - endY, g2d);
        } 
        
        if (endX > x && endY < y) {
            drawTool(x, endY, endX - x, y - endY, g2d);
        }
       
        if (endX < x && endY > y) {
            drawTool(endX, y, x - endX, endY - y, g2d);
        }
        
    }
    
    
    /**
     * 
     * @param theX - 
     * @param theY - 
     * @param theWidth -
     * @param theHeight -
     * @param theGraphics -
     */
    public void drawTool(final int theX, final int theY, final int theWidth, 
                         final int theHeight, final Graphics2D theGraphics) {
        theGraphics.drawRect(theX, theY, theWidth, theHeight);
    }

    
}
