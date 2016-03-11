/*
 * TCSS 305 – Winter 2016 
 * Assignment 5b - PowerPaint
 * 
 */

package tool;

import java.awt.Graphics2D;

/**
 * This class draws an ellipse. 
 * 
 * @author Cynthia Tran
 * @version 1
 */
public class Ellipse extends Rect {
    
    @Override
    public void drawTool(final int theX, final int theY, final int theWidth, 
                         final int theHeight, final Graphics2D theGraphics) {
        theGraphics.drawOval(theX, theY, theWidth, theHeight);
    }
    
   
}
