/*
 * TCSS 305 – Winter 2016 
 * Assignment 5b - PowerPaint
 * 
 */

package model;

import java.awt.Color;
import java.awt.Point;

import tool.Tool;

/**
 * 
 * This class creates an object which gives
 * information to the GUI on what the object
 * is and what characteristics the object has. 
 * 
 * @author Cynthia Tran
 * @version 1
 *
 */
public class DrawShape {
    /**
     * The starting point.
     */
    private final Point myStart;
    /**
     * The ending point.
     */
    private Point myEnd;
    /**
     * The thickness of the shape.
     */
    private final int myThickness;
    /**
     * The color of the shape.
     */
    private final Color myColor;
    /**
     * The tool the shape is.
     */
    private final Tool myTool; 
    

    /**
     * Creates an object initializing all characteristics in the field. 
     * 
     * @param theStart - the start point.
     * @param theEnd - the end point.
     * @param theTool - the tool.
     * @param theThickness - the thickness of the object.
     * @param theColor - the color of the object. 
     */
    public DrawShape(final Point theStart, final Point theEnd, final Tool theTool, 
                     final int theThickness, final Color theColor) {
        myStart = theStart;
        myEnd = theEnd;
        myTool = theTool;
        myThickness = theThickness;
        myColor = theColor;
    }

    /**
     * Gets the starting point.
     * 
     * @return (Point) myStart.clone() - return start point cloned. 
     */
    public Point getStartPoint() {
        return (Point) myStart.clone();
    }

    /**
     * Gets the end point.
     * 
     * @return (Point) myEnd.clone() - returns the end point cloned.
     */
    public Point getEndPoint() {
        return (Point) myEnd.clone();
    }
    
    /**
     * Sets the end point.
     * 
     * @param theX - the x coordinate.
     * @param theY - the y coordinate. 
     */
    public void setEndPoint(final int theX, final int theY) {
        myEnd = new Point(theX, theY);
    }
    
    /**
     * Gets the thickness of the object.
     * 
     * @return myThickness - the thickness. 
     */
    public int getMyThick() {
        return myThickness;
    }
    
    
    /**
     * Gets the tool the object uses.
     * 
     * @return myTool - the tool.
     */
    public Tool getMyTool() {
        return myTool;
        
    }
    
    
    /**
     * Gets the color of the object.
     * 
     * @return myColor - the color. 
     */
    public Color getMyColor() {
        return myColor;
    }

    
    
}
