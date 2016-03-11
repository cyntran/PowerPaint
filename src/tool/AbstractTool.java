/*
 * TCSS 305 – Winter 2016 
 * Assignment 5b - PowerPaint
 * 
 */

package tool;

import java.awt.Graphics;

import model.DrawShape;

/**
 * 
 * @author Cynthia Tran
 * @version 1
 */
public abstract class AbstractTool implements Tool  {
    
    /**
     * Draws the object with the given shape. Each shape is
     * implemented differently. 
     * 
     * @param theGraphics - The graphics object to draw with. 
     * @param theShape - The shape to be drawn. 
     * 
     */
    public abstract void draw(final Graphics theGraphics, final DrawShape theShape);
    
    /**
     * Gets the name of the tool.
     * 
     * @return getClass().getName() - returns the name. 
     */
    public String getName() {
        return getClass().getName();
    }
    
    
}
