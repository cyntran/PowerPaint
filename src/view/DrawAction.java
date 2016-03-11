/*
 * TCSS 305 – Winter 2016 
 * Assignment 5b - PowerPaint
 * 
 */

package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import tool.Circle;
import tool.Ellipse;
import tool.Rect;
import tool.Square;
import tool.Tool;


/**
 * This class coordinates the menu radio buttons in the menu
 * and the toggle buttons in the tool bar so the buttons from
 * the same class uses the same action. 
 * 
 * @author Cynthia Tran
 * @version 1
 *
 */
public class DrawAction extends AbstractAction {

    /**
     * SerialID.
     */
    private static final long serialVersionUID = 4089754817902066034L;
    
    /**
     * Index which contains the first letter of the class. 
     */
    private static final int START_STRING = 5;

    /**
     * A tool.
     */
    private final Tool myTool;

    /**
     * The panel to be drawn on.
     */
    private final PowerPaintPanel myDrawing;
    /**
     * The Square/Circle only checkbox in the menu bar. 
     */
    private final JCheckBox myCheckBox;
    /**
     * The state of the check box. 
     */
    private boolean myChecked;


  /**
   * Creates an object that combines the toggle buttons
   * and the radio buttons together with the same action. 
   * 
   * @param theTool - the tool.
   * @param theIcon - an icon to be added.
   * @param thePanel - the panel to drawn on.
   * @param theCheckBox - the square/circle checkbox. 
   */
    public DrawAction(final Tool theTool, final Icon theIcon, final PowerPaintPanel thePanel, 
                      final JCheckBox theCheckBox) {
        super(theTool.getName().substring(START_STRING, theTool.getName().length()));
        final ImageIcon icon = (ImageIcon) theIcon;

        putValue(Action.LARGE_ICON_KEY, icon);

        putValue(Action.MNEMONIC_KEY,
                 KeyEvent.getExtendedKeyCodeForChar(theTool.getClass().
                                                    getName().charAt(START_STRING)));

        putValue(Action.SELECTED_KEY, true);
        
        myDrawing = thePanel;
        myTool = theTool;
        myCheckBox = theCheckBox;

    }


    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        if (myCheckBox.isSelected()) {
            myChecked = true;
        } else {
            myChecked = false;
        }
        
        myDrawing.setTool(myTool);

        if (myChecked && (myTool.getClass() == Rect.class)) {
            myDrawing.setTool(new Square());
        }

        if (myChecked && (myTool.getClass() == Ellipse.class)) {
            myDrawing.setTool(new Circle());
        } 

    }


}
