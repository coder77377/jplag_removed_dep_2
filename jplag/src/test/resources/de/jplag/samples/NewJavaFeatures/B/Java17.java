public class Java17 {

    public Java17() {
        Shape s = Math.random() > 0.6 ? new Circle(5435) : new Rect(54, 4);
        Shape c = new Circle(43425);
        Shape r = new Rect(14, 21);
        double area = s.area() + c.area() + r.area();
        System.out.println(area);
    }

    private abstract static sealed class Shape permits Circle,Rect {
        public abstract double area();
    }

    private static final class Circle extends Shape {
        private double r;

        private Circle(double r) {
            this.r = r;
        }

        @Override
        public double area() {
            return 2 * Math.PI * r * r;
        }
    }

    private static final class Rect extends Shape {
        private final int a;
        private final int b;

        private Rect(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public double area() {
            return a * b;
        }
    }
}
