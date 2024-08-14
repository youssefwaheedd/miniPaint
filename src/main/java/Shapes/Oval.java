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
public class Oval extends ShapeAbstract {

    private int height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    private int width;

    public Oval(int width, int height) {
        super();
        this.width = width;
        this.height = height;
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
        }
        canvas.setColor(getFillColor());
        canvas.fillOval(pointX, pointY, width, height);
        canvas.setColor(getColor());
        canvas.drawOval(pointX, pointY, width, height);

    }

    @Override
    public void moveTo(Point point) {
        this.setPosition(new Point(point.x + getDraggingPoint().x, point.y + getDraggingPoint().y));
    }

    @Override
    public boolean contains(Point point) {
        double p = ((double) Math.pow((point.x - getPosition().x), 2)
                / (double) Math.pow((width / 2), 2))
                + ((double) Math.pow((point.y - getPosition().y), 2)
                        / (double) Math.pow((height / 2), 2));
        if (p <= 1) {
            return true;
        }
        return false;
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
        shapeObject.put("Oval", shapeDetails);
        return shapeObject;
    }
}
