package academy.kovalevskyi.codingbootcamp.week1.day1;

import academy.kovalevskyi.codingbootcamp.week1.day0.Point;

public class PointWithLabel extends PointWithValue<String> {

    public PointWithLabel(int coordinateX, int coordinateY, String value) {
        super(coordinateX, coordinateY, value);
    }

    public String getLabel() {
        return getValue();
    }

    @Override
    public int compareTo(Point point) {
        if (point instanceof PointWithLabel pwl) {
            return getValue().compareTo(pwl.getValue());
        }
        return super.compareTo(point);
    }
}
