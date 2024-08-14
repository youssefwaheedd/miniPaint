/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.awt.Graphics;
import java.awt.Point;
import org.json.simple.JSONObject;

/**
 *
 * @author youssef
 */
public class Rectangle extends ShapeAbstract {

    private int height;
    private int width;

    public Rectangle(int width, int height) {
        super();
        this.height = height;
        this.width = width;
    }

    @Override
    public void draw(Graphics canvas) {
        int pointX = getPosition().x - width / 2;
        int pointY = getPosition().y - height / 2;
        if (width <= 0 && height > 0) { // width -ve
            pointX += width;
            width = -width;
        } else if (height <= 0 && width > 0) {
            pointY -= height;
            height = -height;
        } else if (width <= 0 && height <= 0) {
            pointX += width;
            width = -width;
            pointY -= height;
            height = -height;
        } else {
            canvas.setColor(getFillColor());
            canvas.fillRect(pointX, pointY, width, height);
            canvas.setColor(getColor());
            canvas.drawRect(pointX, pointY, width, height);
        }

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

    @Override
    public boolean contains(Point point) {
        Point bottomLeft = new Point(getPosition().x - width / 2, getPosition().y + height / 2);
        Point upperRight = new Point(getPosition().x + (width / 2), getPosition().y - height / 2);
        return point.x > bottomLeft.x && point.x < upperRight.x && point.y < bottomLeft.y && point.y > upperRight.y;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @SuppressWarnings("unchecked")
    @Override
    public JSONObject toJSONObject() {
        JSONObject shapeDetails = new JSONObject();
        JSONObject shapeObject = new JSONObject();
        shapeDetails.put("Position X", getPosition().x);
        shapeDetails.put("Position Y", getPosition().y);
        shapeDetails.put("Width", getWidth());
        shapeDetails.put("Height", getHeight());
        shapeDetails.put("redF", getFillColor().getRed());
        shapeDetails.put("greenF", getFillColor().getGreen());
        shapeDetails.put("blueF", getFillColor().getBlue());
        shapeDetails.put("redB", getColor().getRed());
        shapeDetails.put("greenB", getColor().getGreen());
        shapeDetails.put("blueB", getColor().getBlue());
        shapeObject.put("Rectangle", shapeDetails);
        return shapeObject;
    }

}
