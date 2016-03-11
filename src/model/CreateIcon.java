/*
 * TCSS 305 – Winter 2016 
 * Assignment 5b - PowerPaint
 * 
 */

package model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;


import javax.swing.Icon;

/**
 * This program creates the icon in the color menu item based 
 * on the given color. 
 * 
 * @author Cynthia Tran
 * @version 1
 *
 */
public class CreateIcon implements Icon {
    /**
     * The icon size.
     */
    private static final int ICON_SIZE = 14;
    /**
     * The default icon's red value. 
     */
    private static final int RGB_R = 51;
    /**
     * The default icon's blue value.
     */
    private static final int RGB_B = 111;
    /**
     * A color for the icon.
     */
    private Color myColor;

    
    
    /**
     * Creates a new icon with a default color. 
     */
    public CreateIcon() {
        myColor = new Color(RGB_R, 0, RGB_B);
    }

    @Override
    public void paintIcon(final Component theComp, final Graphics theGraphics, 
                          final int theX, final int theY) {
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setPaint(myColor);
        g2d.fillRect(theX, theY, ICON_SIZE, ICON_SIZE);

    }

    /**
     * Sets the color of the icon.
     * 
     * @param theColor - the color to set the icon. 
     */
    public void setColor(final Color theColor) {
        myColor = theColor;
    }


    @Override
    public int getIconWidth() {
        return ICON_SIZE;
    }

    @Override
    public int getIconHeight() {
        return ICON_SIZE;
    }


}
