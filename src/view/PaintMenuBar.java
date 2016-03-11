/*
 * TCSS 305 – Winter 2016 
 * Assignment 5b - PowerPaint
 * 
 */

package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import model.CreateIcon;
import tool.Circle;
import tool.Ellipse;
import tool.Rect;
import tool.Square;

/**
 * This class creates the JMenuBar to be added to the 
 * PowerPaintGUI. 
 * 
 * @author Cynthia Tran
 * @version 1
 */
public class PaintMenuBar extends JMenuBar implements ActionListener {

    /**
     * A serial ID. 
     */
    private static final long serialVersionUID = 1207052513774460627L;

    /**
     * Slider's max value.
     */
    private static final int SLIDER_MAX = 20;

    /**
     * Slider's tick value.
     */
    private static final int SLIDER_INIT = 5;

    /**
     * Slider's major tick value.
     */
    private static final int MINOR_TICK = 1;
    /**
     * A string for the about menu item.
     */
    private static final String ABOUT = "About...";
    /**
     * A string for the color menu item.
     */
    private static final String COLOR = "Color...";
    /**
     * A string for the exit menu item.
     */
    private static final String EXIT = "Exit";
    
    /**
     * The panel to be drawn on.
     */
    private final PowerPaintPanel myDrawing;
    /**
     * An undo menu item. 
     */
    private final JMenuItem myUndo;
    /**
     * A boolean to check the state of the check box.
     */
    private boolean myChecked;
    /**
     * A check box for the Square/Circle only menu item.
     */
    private final JCheckBox myCheckBox;
    /**
     * A list of all DrawActions.
     */
    private final List<DrawAction> myDrawActions;
    /**
     * The frame in the GUI.
     */
    private final JFrame myFrame;
    /**
     * A color.
     */
    private Color myColor;
    /**
     * The icon in the color menu item. 
     */
    private CreateIcon myColorIcon;


    /**
     * Creates a menu bar. 
     * 
     * @param theDrawing - the panel to be drawn on.
     * @param theUndo - the undo menu item.
     * @param theChecked - the state of the check box.
     * @param theCheckBox - the Square/Circle only check box.
     * @param theDrawActions - the list of DrawActions.
     * @param theFrame - the frame for the GUI. 
     */
    public PaintMenuBar(final PowerPaintPanel theDrawing, 
                        final JMenuItem theUndo, 
                        final boolean theChecked,
                        final JCheckBox theCheckBox, 
                        final List<DrawAction> theDrawActions, 
                        final JFrame theFrame) {
        super();
        myDrawing = theDrawing;
        myUndo = theUndo;
        myChecked = theChecked;
        myCheckBox = theCheckBox;
        myDrawActions = theDrawActions;
        myFrame = theFrame;
        addMenuItems();
        
    }

    /**
     * Adds all the menu items together. 
     * 
     */
    public final void addMenuItems() {
        add(getFile());   
        add(getOptions());
        add(getTools());
        add(getHelp());
    }


    /**
     * Returns the JMenu for file. 
     * 
     * @return file - returns file. 
     */
    public final JMenu getFile() {
        final JMenu file = new JMenu("File");
        file.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(final MenuEvent theE) {
                if (myDrawing.getList().isEmpty()) {
                    myUndo.setEnabled(false);
                } else {
                    myUndo.setEnabled(true);
                }
            }

            @Override
            public void menuDeselected(final MenuEvent theE) {
            }

            @Override
            public void menuCanceled(final MenuEvent theE) {
            }

        });

        file.setMnemonic(KeyEvent.VK_F);
        myUndo.addActionListener(new AbstractAction("Undo all changes") {
            /**
             * 
             */
            private static final long serialVersionUID = -2993334397060012186L;

            public void actionPerformed(final ActionEvent theEvent) {
                myDrawing.undoAll();
                myDrawing.repaint();
            }
        });
        
        final JMenuItem exit = new JMenuItem(EXIT);
        exit.addActionListener(this);
        file.add(myUndo);
        file.addSeparator();
        file.add(exit);
        return file;
    }


    /**
     * A method to check the state of the check box, if
     * the check box is checked, then this method will 
     * handle the drawing panel objects accordingly. 
     * 
     * 
     * @param theCheckBox - the check box to be used. 
     */
    public final void checkCheckBox(final JCheckBox theCheckBox) {      
        if (theCheckBox.isSelected()) {
            myChecked = true;
        } else {
            myChecked = false;
        }

        if (myChecked && (myDrawing.getTool().getClass() == Rect.class)) {
            myDrawing.setTool(new Square());
        }

        if (myChecked && (myDrawing.getTool().getClass() == Ellipse.class)) {
            myDrawing.setTool(new Circle());
        } 

        if (!myChecked && (myDrawing.getTool().getClass() == Square.class)) {
            myDrawing.setTool(new Rect());
        }

        if (!myChecked && (myDrawing.getTool().getClass() == Circle.class)) {
            myDrawing.setTool(new Ellipse());
        }

    }


    /**
     * Returns the JMenu for options.
     * 
     * @return options - returns options.
     */
    public final JMenu getOptions() {
        final JMenu options = new JMenu("Options");
        options.setMnemonic(KeyEvent.VK_O);
        myCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theE) {
                checkCheckBox(myCheckBox);
            }
        });

        final JMenu subMenu = new JMenu("Thickness");
        final JSlider slide = new JSlider(SwingConstants.HORIZONTAL, 
                                          0, SLIDER_MAX, SLIDER_INIT);
        slide.setMajorTickSpacing(SLIDER_INIT);
        slide.setMinorTickSpacing(MINOR_TICK);
        slide.setPaintTicks(true);
        slide.setPaintLabels(true);
        slide.addChangeListener(new ChangeListener() {
            public void stateChanged(final ChangeEvent theEvent) {
                myDrawing.setThickness(slide.getValue());    
                myDrawing.repaint();
            }
        });
        subMenu.add(slide);
        final JMenuItem colorMenu = new JMenuItem(COLOR);
        colorMenu.addActionListener(this);
        colorMenu.setMnemonic(KeyEvent.VK_C);
        myColorIcon = new CreateIcon();

        options.add(myCheckBox);
        myCheckBox.setMnemonic(KeyEvent.VK_S);
        options.addSeparator();
        options.add(subMenu);
        subMenu.setMnemonic(KeyEvent.VK_T);
        options.addSeparator();
        colorMenu.setIcon(myColorIcon);
        options.add(colorMenu);
        return options;
    }


    /**
     * Returns the JMenu for tools. 
     * 
     * @return tool - returns tool. 
     */
    public final JMenu getTools() {
        final JMenu tMenu = new JMenu("Tools");
        tMenu.setMnemonic(KeyEvent.VK_T);
        final ButtonGroup radGroup = new ButtonGroup();
        final ArrayList<JRadioButtonMenuItem> list = new ArrayList<JRadioButtonMenuItem>(); 
        for (final DrawAction a: myDrawActions) {
            final JRadioButtonMenuItem item = new JRadioButtonMenuItem(a);
            list.add(item);
            radGroup.add(item);
            tMenu.add(item);
        }
        list.get(0).setSelected(true);
        return tMenu;
    }



    /**
     * Returns the JMenu for help.
     * 
     * @return help - returns help. 
     */
    public final JMenu getHelp() {
        final JMenu help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_H);
        final JMenuItem about = new JMenuItem(ABOUT);
        about.addActionListener(this);
        about.setMnemonic(KeyEvent.VK_A);
        help.add(about);
        return help;
    }

    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        if (COLOR.equals(theEvent.getActionCommand())) {
            final Color c = JColorChooser.showDialog(myDrawing, "Choose Color", Color.BLACK);
            myColor = c;
            myColorIcon.setColor(myColor);
            myDrawing.setColor(myColor);
            
        }

        if (ABOUT.equals(theEvent.getActionCommand())) { 
            final ImageIcon helpIcon = new ImageIcon("./images/paintbrush2.png");
            JOptionPane.showMessageDialog(myFrame, "TCSS 305 PowerPaint\n"
                            + "Winter 2016\nCynthia Tran",
                            "About",
                            JOptionPane.INFORMATION_MESSAGE,
                            helpIcon);
        } 
        if (EXIT.equals(theEvent.getActionCommand())) {
            System.exit(0);
        }

    }



}
