/*
 * TCSS 305 – Winter 2016 
 * Assignment 5b - PowerPaint
 * 
 */

package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import model.DrawShape;
import model.PencilDrawShape;
import tool.Pencil;
import tool.Tool;

/**
 * This class creates a panel which will be used to draw on in the GUI. 
 * 
 * @author Cynthia Tran
 * @version 1
 *
 */
public class PowerPaintPanel extends JPanel {
    /**
     * Serial ID.
     */
    private static final long serialVersionUID = 5849475526623918724L;
    /**
     * The default thickness for the tools. 
     */
    private static final int DEFAULT_THICK = 5;
    /**
     * The default tool's red value.
     */
    private static final int RGB_R = 51;
    /**
     * The default tool's blue value.
     */
    private static final int RGB_B = 111;
    /**
     * A tool. 
     */
    private Tool myTool;
    /**
     * A color.
     */
    private Color myColor;
    /**
     * The thickness of the drawn object.
     */
    private int myThickness;
    /**
     * The shapes drawn.
     */
    private DrawShape myShape;
    /**
     * A collection of all the shapes drawn. 
     */
    private final List<DrawShape> myDrawings;

  
    
    
    /**
     * Creates the panel, instantiating the pencil to be 
     * the default tool, with a thickness of 5 and with the UW color. 
     */
    public PowerPaintPanel() {
        super();
        this.addMouseListener(new ActionClass());
        this.addMouseMotionListener(new ActionClass());
        myTool = new Pencil();
        myDrawings = new ArrayList<DrawShape>();
        myThickness = DEFAULT_THICK;
        myColor = new Color(RGB_R, 0, RGB_B);
    }

    
    /**
     * Sets the tool. 
     * 
     * @param theTool - the Tool to be set.  
     */
    public void setTool(final Tool theTool) {
        myTool = theTool;
    }
    
    
    /**
     * Gets the last DrawShape object drawn.
     * 
     * @return myShape - the last DrawShape object.
     */
    public DrawShape getMyShape() {
        return myShape;
    }
    
    
    /**
    * Sets the color. 
    * 
    * @param theColor - the color to be set.  
    */
    public void setColor(final Color theColor) {
        myColor = theColor;
    }
    
    /**
     * Gets the current tool.
     * 
     * @return myTool - the tool.
     */
    public Tool getTool() {
        return myTool;
    }
    

    
    /**
     * Sets the thickness of the tool.
     * 
     * @param theThick - the thickness to be set. 
     */
    public void setThickness(final int theThick) {
        myThickness = theThick;
    }
   
   
    /**
     * Creates and returns a new reference to all the DrawShapes created. 
     * 
     * @return myDrawingsCopy - returns a reference to myDrawings collection.
     */
    public List<DrawShape> getList() {
        final ArrayList<DrawShape> drawingsCopy = new ArrayList<DrawShape>();
        drawingsCopy.addAll(myDrawings);
        return drawingsCopy;
    }
    
    
    /**
     * Undos all the drawings by removing every
     * element of the list. 
     */
    public void undoAll() {
        myDrawings.removeAll(myDrawings);
    }
    
    
    @Override 
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        if (myShape != null) {
            for (final DrawShape s : myDrawings) {
                s.getMyTool().draw(theGraphics, s);
            }
        }
        
    }

    
    /**
     * This class draws the shape on the  panel 
     * based on user input.
     * 
     * @author Cynthia Tran
     * @version 1
     *
     */
    class ActionClass extends MouseInputAdapter {  
        
        @Override
        public void mousePressed(final MouseEvent theEvent) {
            final Point p = new Point(theEvent.getX(), theEvent.getY());
            
            if (myTool.getClass() == Pencil.class) {
                myShape = new PencilDrawShape(p, p, myTool, myThickness, myColor);  
            } else {
                myShape = new DrawShape(p, p, myTool, myThickness, myColor);
            }
            
            if (myShape.getMyThick() != 0) {
                myDrawings.add(myShape);
            }
            repaint(); 
        }
        
        
        @Override
        public void mouseDragged(final MouseEvent theEvent) {
            myShape.setEndPoint(theEvent.getX(), theEvent.getY());
            repaint();
        }
       
    }
    

}
