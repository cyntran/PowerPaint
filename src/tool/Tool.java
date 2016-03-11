/*
 * TCSS 305 – Winter 2016 
 * Assignment 5b - PowerPaint
 * 
 */

package tool;

import java.awt.Graphics;

import model.DrawShape;


/**
 * This interface is implemented by classes which are
 * classified as Tools to use the following draw method to draw
 * on the panel. 
 * 
 * @author Cynthia Tran
 * @version 1
 *
 */
public interface Tool {
    /**
     * Draws the object with the given shape. Each shape is
     * implemented differently so this method be overridden 
     * in the children classes of AbstractTool. 
     * 
     * @param theGraphics - the Graphics to draw with.
     * @param theShape - the given shape. 
     */
    void draw(Graphics theGraphics, DrawShape theShape);
    
    /**
     * 
     * @return getName - returns the name of the object.
     */
    String getName();
    

}
