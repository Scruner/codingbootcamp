package academy.kovalevskyi.codingbootcamp.week1.day0;

public class Point implements Comparable<Point> {
    private final int coordinateX;
    private final int coordinateY;

    public Point(final int coordinateX, final int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public int getX() {
        return coordinateX;
    }

    public int getY() {
        return coordinateY;
    }

    public Point sum(final Point that) {
        return new Point(coordinateX + that.getX(), coordinateY + that.getY());
    }

    public Point updateX(int newX) {
        return new Point(newX, coordinateY);
    }

    public Point updateY(int newY) {
        return new Point(coordinateX, newY);
    }

    public int distanceTo(Point that) {
        return NumberUtils.powerRecursive((coordinateX - that.getX()), 2)
                + NumberUtils.powerRecursive((coordinateY - that.getY()), 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return coordinateX == point.getX() && coordinateY == point.getY();
    }

    @Override
    public int hashCode() {
        return this.getX() + this.getY();
    }

    @Override
    public String toString() {
        return "Point{"
                + "X: "
                + coordinateX
                + ", Y: "
                + coordinateY
                + "}";
    }

    @Override
    public int compareTo(Point that) {
        return (coordinateX + coordinateY) - (that.getX() + that.getY());
    }
}
