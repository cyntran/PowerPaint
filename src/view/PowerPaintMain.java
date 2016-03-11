/*
 * TCSS 305 – Winter 2016 
 * Assignment 5b - PowerPaint
 * 
 */

package view;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 * The main class which runs the PowerPaintGUI. 
 * 
 * @author Cynthia Tran
 * @version 1
 */
public final class PowerPaintMain {
    
    /**
     * Private constructor, to prevent instantiation of this class.
     */
    private PowerPaintMain() {
    }
    
/**
 * The main method to run the GUI. 
 * 
 * @param theArgs - arguments. 
 */
    public static void main(final String[] theArgs) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        } catch (final InstantiationException e) {
            e.printStackTrace();
        } catch (final IllegalAccessException e) {
            e.printStackTrace();
        } catch (final UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PowerPaintGUI().start();
            }
        });
        
    }

}
