
public class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void set(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Point translate(int translateX, int translateY) {
        return new Point(x + translateX, y + translateY);
    }

    /*
     * angleRad là góc xoay, tính bằng radian
     */
    public Point rotate(double angleRad) {
        return new Point((int) Math.round(Math.cos(angleRad) * x - Math.sin(angleRad) * y),
                (int) Math.round(Math.sin(angleRad) * x + Math.cos(angleRad) * y));
    }
}
