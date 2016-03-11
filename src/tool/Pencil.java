/*
 * TCSS 305 – Winter 2016 
 * Assignment 5b - PowerPaint
 * 
 */

package tool;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import java.util.ArrayList;

import model.DrawShape;
import model.PencilDrawShape;

/**
 * This class draws with pencil. 
 * 
 * @author Cynthia Tran
 * @version 1
 *
 */
public class Pencil extends AbstractTool {

    @Override
    public void draw(final Graphics theGraphics, final DrawShape theShape) {
        final PencilDrawShape pencil = (PencilDrawShape) theShape;

        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setStroke(new BasicStroke(theShape.getMyThick()));
        g2d.setColor(theShape.getMyColor());
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                             RenderingHints.VALUE_ANTIALIAS_ON);
        
        final Path2D path = new Path2D.Double();
        path.moveTo(pencil.getStartPoint().getX(), 
                      pencil.getStartPoint().getY());

        final ArrayList<Point> paths = (ArrayList<Point>) pencil.getPoints();
        
        for (final Point p : paths) {
            path.lineTo(p.getX(), p.getY());
        }
        
        g2d.draw(path);
                
    }

}
