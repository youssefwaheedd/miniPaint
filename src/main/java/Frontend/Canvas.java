/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frontend;

import Shapes.ResizeSquare;
import Shapes.ShapeAbstract;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author youssef
 */
@SuppressWarnings("unused")
public class Canvas extends JPanel implements DrawingEngine {

    public ArrayList<ShapeAbstract> shapes;
    public ArrayList<ResizeSquare> squares;

    public Canvas() {
        shapes = new ArrayList<>();
        squares = new ArrayList<>();
    }

    public void addSquare(ResizeSquare sq) {
        squares.add(sq);
    }

    public void removeSquare(ResizeSquare sq) {
        for (int i = 0; i < squares.size(); i++) {
            if (squares.get(i) == sq) {
                squares.remove(i);
            }
        }
    }

    @Override
    public void addShape(ShapeAbstract shape) {
        shapes.add(shape);
    }

    @Override
    public void removeShape(ShapeAbstract shape) {
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) == shape)
                shapes.remove(i);
        }
    }

    @Override
    public ShapeAbstract[] getShapes() {
        ShapeAbstract[] shape = new ShapeAbstract[shapes.size()];
        shape = shapes.toArray(shape);
        return shape;
    }

    @Override
    public void paintComponent(Graphics canvas) {
        super.paintComponent(canvas);
        refresh(canvas);
        refreshSquares(canvas);
    }

    @Override
    public void refresh(Graphics canvas) {
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).draw(canvas);
        }
    }

    public void refreshSquares(Graphics canvas) {
        for (int i = 0; i < squares.size(); i++) {
            squares.get(i).draw(canvas);
        }
    }

    public boolean contains(Point point) {
        for (int i = 0; i < squares.size(); i++) {
            if (squares.get(i).contains(point)) {
                return true;
            }
        }
        return false;
    }

}
