/*
 * TCSS 305 – Winter 2016 
 * Assignment 5b - PowerPaint
 * 
 */

package model;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import tool.Tool;


/**
 * This class is a DrawShape for pencil, since it is
 * implemented differently from the other DrawShapes, it
 * must be in its own class. 
 * 
 * @author Cynthia Tran
 * @version 1
 */
public class PencilDrawShape extends DrawShape {

    /**
     * A list of points for the pencil to draw. 
     */
    private final List<Point> myPathPoints = new ArrayList<Point>();
    
    /**
     * Creates a new PencilDrawShape object. 
     * 
     * @param theStart - the starting point.
     * @param theEnd - the end point.
     * @param theTool - the tool.
     * @param theThickness - the thickness of the object.
     * @param theColor -  the color of the object. 
     */
    public PencilDrawShape(final Point theStart, final Point theEnd, final Tool theTool, 
                           final int theThickness, final Color theColor) {
        super(theStart, theEnd, theTool, theThickness, theColor);
        
    }
    
   /**
    * Adds a point to the path. 
    * 
    * @param theP - the point to be added. 
    */
    public void addPoint(final Point theP) {
        myPathPoints.add(theP);
    }

    
    /**
     * Gets the points of the path the pencil will draw. 
     * 
     * @return paths - returns a deep copy of the collection. 
     */
    public List<Point> getPoints() {
        final ArrayList<Point> paths = new ArrayList<Point>();
        for (int i = 0; i < myPathPoints.size(); i++) {
            final Point p = myPathPoints.get(i);
            paths.add(p);
        }
        return paths;
    }
    
    
    /**
     * Sets the end point for the path. 
     * 
     * @param theX - the x coordinate.
     * @param theY - the y coordinate. 
     */
    public void setEndPoint(final int theX, final int theY) {
        addPoint(new Point(theX, theY));
    }

    
}
