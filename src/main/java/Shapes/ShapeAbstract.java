/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import org.json.simple.JSONObject;

/**
 *
 * @author youssef
 */
public abstract class ShapeAbstract implements Shape, Moveable {
    private Point position;
    private Color color;
    private Color fillColor;
    private Point draggingPoint;

    public ShapeAbstract() {
        this.position = new Point();
        this.color = new Color(Color.BLACK.getRGB());
        this.fillColor = new Color(Color.BLACK.getRGB());
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    @Override
    public Point getDraggingPoint() {
        return draggingPoint;
    }

    @Override
    public void setDraggingPoint(Point draggingPoint) {
        this.draggingPoint = draggingPoint;
    }

    public abstract JSONObject toJSONObject();

    @Override
    public abstract void draw(Graphics canvas);

    @Override
    public abstract void moveTo(Point draggingPoint);

    @Override
    public abstract boolean contains(Point point);

    public double distance(Point a, Point b) {
        return Math.sqrt((a.getX() - b.getX()) * (a.getX() - b.getX()) + (a.getY() - b.getY()) * (a.getY() - b.getY()));
    }

}
