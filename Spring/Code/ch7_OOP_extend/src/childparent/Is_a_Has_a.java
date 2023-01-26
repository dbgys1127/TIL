package childparent;

public class Is_a_Has_a {
    public static void main(String[] args) {
        Point[] p = {
                new Point(100, 100),
                new Point(140, 50),
                new Point(200,100)
        };
        Triangle t = new Triangle(p);
        t.color = "white";
        Circle c = new Circle(new Point(150, 150), 5);
        c.color = "red";
        t.draw();
        c.draw();
    }
}

class Shape {
    String color = "black";

    void draw() {
        System.out.printf("[color=%s]\n",color);
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0, 0);
    }
    String getXY() {
        return "(" + x + "," + y + ")";
    }
}

class Circle extends Shape {
    Point center;
    int r;

    public Circle() {
        this(new Point(0, 0), 100);
    }

    public Circle(Point center, int r) {
        this.center = center;
        this.r = r;
    }
    void draw() {
        System.out.printf("[center=(%d,%d), r=%d,color=%s]\n", center.x, center.y, r, color);
    }
}

class Triangle extends Shape {
    Point[] p = new Point[3];

    public Triangle(Point[] p) {
        this.p = p;
    }
    void draw() {
        System.out.printf("[p1=%s, p2=%s, p3=%s, color=%s]\n", p[0].getXY(),p[1].getXY(),p[2].getXY(),color);
    }
}
