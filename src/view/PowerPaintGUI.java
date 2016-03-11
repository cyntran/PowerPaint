/*
 * TCSS 305 – Winter 2016 
 * Assignment 5b - PowerPaint
 * 
 */

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

import tool.Ellipse;
import tool.Line;
import tool.Pencil;
import tool.Rect;


/**
 * This program is a paint application that allows
 * the user to draw with a pencil, ellipse, rectangle,
 * line, square, and circle. It is very neat. 
 * 
 * 
 * @author Cynthia Tran
 * @version 1
 *
 */
public class PowerPaintGUI {

    /**
     * A frame.
     */
    private final JFrame myFrame;

    /**
     * A panel for the drawing. 
     */
    private final PowerPaintPanel myDrawing = new PowerPaintPanel();

    /**
     * The Icon for the frame. 
     */
    private final ImageIcon myFrameIcon = new ImageIcon("./images/paintbrush.png");
    
    /**
     * A check box for the Square/Circle only menu item.
     */
    private boolean myChecked;

    

    /**
     * The constructor which defines panel and frame. 
     */
    public PowerPaintGUI() {
        super();
        myFrame = new JFrame("PowerPaint");

    }


    /**
     * Sets the GUI up so that the DrawActions are added to
     * the toolbar and the menu in the frame. 
     */
    public void start() { 
        final ArrayList<DrawAction> drawActions = new ArrayList<DrawAction>();
        final JCheckBox checkBox = new JCheckBox("Square/Circle only");
        final JMenuItem undo = new JMenuItem("Undo all changes");
        drawActions.add(new DrawAction(new Pencil(), 
                                         new ImageIcon("./images/pencil_bw.gif"), myDrawing, 
                                         checkBox));
        drawActions.add(new DrawAction(new Line(), new ImageIcon("./images/line_bw.gif"),
                                         myDrawing, checkBox));
        drawActions.add(new DrawAction(new Rect(), new ImageIcon("./"
                        + "images/rectangle_bw.gif"), myDrawing, checkBox));
        drawActions.add(new DrawAction(new Ellipse(), 
                                         new ImageIcon("./images/ellipse_bw.gif"), myDrawing, 
                                         checkBox));
        
        myFrame.setIconImage(myFrameIcon.getImage());
        myFrame.setVisible(true);
        final PaintToolBar toolBar = new PaintToolBar((ArrayList<DrawAction>) drawActions);
        final PaintMenuBar menuBar = new PaintMenuBar(myDrawing, undo, myChecked,
                                            checkBox, drawActions, myFrame);
        myFrame.add(toolBar, BorderLayout.SOUTH);
        myFrame.setJMenuBar(menuBar);
        myDrawing.setBackground(Color.WHITE);
        drawPanel();
        myFrame.pack();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
    /**
     * Creates the drawing panel to be drawn on. 
     */
    public void drawPanel() {
        final Dimension panelSize = new Dimension(500, 400);
        myDrawing.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        myDrawing.setPreferredSize(panelSize);
        myFrame.getContentPane().add(myDrawing, BorderLayout.CENTER);
    }


  
}
