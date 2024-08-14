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
public class LineSegment extends ShapeAbstract {

    private Point point1;
    private Point point2;

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public LineSegment(Point point1, Point point2) {
        super();
        this.point1 = point1;
        this.point2 = point2;

    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(getFillColor());
        canvas.drawLine(point1.x, point1.y, point2.x, point2.y);
        this.setPosition(new Point((point1.x + point2.x) / 2, (point1.y + point2.y) / 2));
    }

    @Override
    public void moveTo(Point point) {
        point1.translate(point.x - getPosition().x + getDraggingPoint().x,
                point.y - getPosition().y + getDraggingPoint().y);
        point2.translate(point.x - getPosition().x + getDraggingPoint().x,
                point.y - getPosition().y + getDraggingPoint().y);
    }

    @Override
    public boolean contains(Point point) {
        return (distance(point1, point) + distance(point2, point) == distance(point1, point2));
    }

    @SuppressWarnings("unchecked")
    @Override
    public JSONObject toJSONObject() {
        JSONObject shapeDetails = new JSONObject();
        JSONObject shapeObject = new JSONObject();
        shapeDetails.put("x1", getPoint1().x);
        shapeDetails.put("y1", getPoint1().y);
        shapeDetails.put("x2", getPoint2().x);
        shapeDetails.put("y2", getPoint2().y);
        shapeDetails.put("redF", getFillColor().getRed());
        shapeDetails.put("greenF", getFillColor().getGreen());
        shapeDetails.put("blueF", getFillColor().getBlue());
        shapeObject.put("Line", shapeDetails);
        return shapeObject;
    }

}
