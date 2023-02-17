package exercise;

// BEGIN
public class Segment {
    private Point beginSegmentPoint;
    private Point endSegmentPoint;

    public Segment(Point beginSegmentPoint, Point endSegmentPoint) {
        this.beginSegmentPoint = beginSegmentPoint;
        this.endSegmentPoint = endSegmentPoint;
    }

    public Point getBeginPoint() {
        return beginSegmentPoint;
    }

    public Point getEndPoint() {
        return endSegmentPoint;
    }

    public Point getMidPoint() {
        int middleX = (beginSegmentPoint.getX() + endSegmentPoint.getX()) / 2;
        int middleY = (beginSegmentPoint.getY() + endSegmentPoint.getY()) / 2;

        return new Point(middleX, middleY);
    }
}
// END
