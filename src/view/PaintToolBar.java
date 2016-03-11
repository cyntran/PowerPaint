/*
 * TCSS 305 – Winter 2016 
 * Assignment 5b - PowerPaint
 * 
 */

package view;

import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * Creates the tool bar to be added to the PowerPaintGUI. 
 * 
 * @author Cynthia Tran
 * @version 1
 *
 */
public class PaintToolBar extends JToolBar {

    /**
     * The serial ID.
     */
    private static final long serialVersionUID = -1173067301214856841L;
 
    
   /**
    * Creates a tool bar with the given DrawAction collection. 
    * 
    * @param theDrawActions - the collection for instantiating the toolbar GUI. 
    */
    public PaintToolBar(final List<DrawAction> theDrawActions) {
        super();
        final List<DrawAction> drawActions = theDrawActions; 
        final ButtonGroup butGroup = new ButtonGroup();
        for (final DrawAction a: drawActions) {
            final JToggleButton buttons = new JToggleButton(a);
            butGroup.add(buttons);
            add(buttons);
        }

    }


}
