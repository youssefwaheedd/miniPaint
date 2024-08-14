/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import org.json.simple.JSONObject;

/**
 *
 * @author youssef
 */
public class Triangle extends ShapeAbstract {

    private Point point1;
    private Point point2;
    private Point point3;

    public Triangle(Point point1, Point point2, Point point3) {
        super();
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

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

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }

    @Override
    public void draw(Graphics canvas) {
        Polygon triangle = new Polygon();
        triangle.addPoint(point1.x, point1.y);
        triangle.addPoint(point2.x, point2.y);
        triangle.addPoint(point3.x, point3.y);
        this.setPosition(new Point((point1.x + point2.x + point3.x) / 3, (point1.y + point2.y + point3.y) / 3));
        canvas.setColor(getFillColor());
        canvas.fillPolygon(triangle);
        canvas.setColor(getColor());
        canvas.drawPolygon(triangle);
    }

    @Override
    public void moveTo(Point point) {
        point1.translate(point.x - getPosition().x + getDraggingPoint().x,
                point.y - getPosition().y + getDraggingPoint().y);
        point2.translate(point.x - getPosition().x + getDraggingPoint().x,
                point.y - getPosition().y + getDraggingPoint().y);
        point3.translate(point.x - getPosition().x + getDraggingPoint().x,
                point.y - getPosition().y + getDraggingPoint().y);
    }

    @Override
    public boolean contains(Point point) {
        double a = area(point1.x, point1.y, point2.x, point2.y, point3.x, point3.y);
        double a1 = area(point.x, point.y, point2.x, point2.y, point3.x, point3.y);
        double a2 = area(point1.x, point1.y, point.x, point.y, point3.x, point3.y);
        double a3 = area(point1.x, point1.y, point2.x, point2.y, point.x, point.y);
        return (a == a1 + a2 + a3);
    }

    static double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
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
        shapeDetails.put("x3", getPoint3().x);
        shapeDetails.put("y3", getPoint3().y);
        shapeDetails.put("redF", getFillColor().getRed());
        shapeDetails.put("greenF", getFillColor().getGreen());
        shapeDetails.put("blueF", getFillColor().getBlue());
        shapeDetails.put("redB", getColor().getRed());
        shapeDetails.put("greenB", getColor().getGreen());
        shapeDetails.put("blueB", getColor().getBlue());
        shapeObject.put("Triangle", shapeDetails);
        return shapeObject;
    }

}
