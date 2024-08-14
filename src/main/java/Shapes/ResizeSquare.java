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
public class ResizeSquare extends ShapeAbstract {

    // public Point getPoint() {
    // return point;
    // }
    //
    // public void setPoint(Point point) {
    // this.point = point;
    // }
    private int height;
    private int width;

    // private Point point;
    public ResizeSquare(int width, int height) {
        super();
        this.height = height;
        this.width = width;

    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(Color.RED);
        canvas.fillRect(getPosition().x - width / 2, getPosition().y - height / 2, width, height);
        canvas.setColor(Color.RED);
        canvas.drawRect(getPosition().x - width / 2, getPosition().y - height / 2, width, height);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void moveTo(Point point) {
        this.setPosition(new Point(point.x + getDraggingPoint().x, point.y + getDraggingPoint().y));
    }

    public void moveTomove(Point point) {

        this.setPosition(point);
    }

    @Override
    public boolean contains(Point point) {
        Point bottomLeft = new Point(getPosition().x - width / 2, getPosition().y + height / 2);
        Point upperRight = new Point(getPosition().x + (width / 2), getPosition().y - height / 2);
        return point.x > bottomLeft.x && point.x < upperRight.x && point.y < bottomLeft.y && point.y > upperRight.y;
    }

    @Override
    public JSONObject toJSONObject() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
