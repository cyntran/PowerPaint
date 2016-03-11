/*
 * TCSS 305 – Winter 2016 
 * Assignment 5b - PowerPaint
 * 
 */

package tool;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;

import model.DrawShape;

/**
 * This class draws a line. 
 * 
 * @author Cynthia Tran
 * @version 1
 */
public class Line extends AbstractTool {

    @Override
    public void draw(final Graphics theGraphics, final DrawShape theShape) {
        final Path2D path = new Path2D.Double();
        path.moveTo(theShape.getStartPoint().getX(), 
                      theShape.getStartPoint().getY());
        path.lineTo(theShape.getEndPoint().getX(),
                      theShape.getEndPoint().getY());
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                             RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(theShape.getMyThick()));
        g2d.setColor(theShape.getMyColor());
        g2d.draw(path);
        
    }


}
