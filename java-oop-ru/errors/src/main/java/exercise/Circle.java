package exercise;

// BEGIN
public class Circle {
    private Point circlePoint;
    private int radius;

    public Circle(Point circlePoint, int radius) {
        this.circlePoint = circlePoint;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius >= 0) {
            return Math.PI * radius * radius;
        } else {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }
    }
}
// END
