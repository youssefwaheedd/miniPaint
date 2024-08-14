/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Frontend;

import Shapes.ShapeAbstract;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author youssef
 */
@SuppressWarnings("unused")
public interface DrawingEngine {
    /* manage shapes objects */
    public void addShape(ShapeAbstract shape);

    public void removeShape(ShapeAbstract shape);

    /* return the created shapes objects */
    public ShapeAbstract[] getShapes();

    /* redraw all shapes on the canvas */
    public void refresh(Graphics canvas);
}
