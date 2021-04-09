public class MyVector {
    public static MyVector oX = new MyVector(1,0);


    private int a, b;

    public MyVector(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public MyVector(Point pA, Point pB) {
        set(pA, pB);
    }

    public double angleRadian(MyVector v) {
        return Math.acos((a * v.a + b * v.b) * 1.0 / (Math.sqrt(a * a + b * b) * Math.sqrt(v.a * v.a + v.b * v.b)));
    }

    public void set(Point pA, Point pB) {
        this.a = pB.getX() - pA.getX();
        this.b = pB.getY() - pA.getY();
    }
}
