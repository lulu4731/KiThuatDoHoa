
import java.awt.*;
import java.util.*;
import java.util.List;

/*
 * The PolyLine class model a line made up of many points
 */
public class PolyLine {
    List<Point> list = new ArrayList<>();
    int[][] board = new int[190][130];
    int Color = 0;
    private int x1, y1, x2, y2;
    int netVe = 0;
    int dem = 0;
    private CoordListener listener;

    public void setNetVe(int netVe) {
        this.netVe = netVe;
    }

    // Constructor
    public PolyLine() {
        x1 = y1 = x2 = y2 = -1;

    }

    public PolyLine(CoordListener listener) {
        this.listener = listener;
        System.out.println("dddd");
        listener.changeColor(Color);
    }

    //    public List<Integer> ToadoX(){
//        List<Integer> listX = new ArrayList<>();
//        listX = xList;
//        return listX;
//    }
    // Add a point to this PolyLine
    public void addPoint(int x, int y) {
        if (x1 == -1) {
            x1 = x;
            y1 = y;
        } else {
            x2 = x;
            y2 = y;
            if (netVe == 1 || netVe == 2 || netVe == 3 || netVe == 0) {
                y2 = y1;
                LineBres(x1, y1, x2, y2);
            } else if (netVe == 4) {
                HCN(x1, y1, x2, y2);
            } else {
                tamGiac(x1, y1, x2, y2);
            }
//
        }
//        xList.add(x);
//        yList.add(y);
//        System.out.println("x=" + x);
    }

    // This PolyLine paints itself given the Graphics context
    public void draw(Graphics g) { // draw itself
        for (Point p : list) {

            PutPixel(p, Color, g);
        }
    }

    public void clearLine(Graphics g) { // draw itself
        for (Point p : list) {
            PutPixel(p, 0xffffff, g);
        }
    }

    public void clearList() {
        list.clear();
    }

    public void clear() {
        x1 = x2 = y1 = y2 = -1;
        list.clear();

    }

    public void HCN(int x1, int y1, int x2, int y2) {
        LineBres(x1, y1, x2, y1);
        LineBres(x1, y2, x1, y1);
        LineBres(x2, y2, x1, y2);
        LineBres(x2, y1, x2, y2);
    }

    public void tamGiac(int x1, int y1, int x2, int y2) {
        LineBres(x1, y1, x2 + 1, y1);
        LineBres(x2, y1 + 2, x2 + 2, y1);
        LineBres(x2, y1 - 2, x2 + 2, y1);
        LineBres(x2, y1 - 2, x2, y1 + 2);
    }

    public void PutPixel(Point p, int Color, Graphics g) {
        int xm = p.getX() + 190 / 2;
        int ym = 130 / 2 - p.getY();

        board[xm][ym] = Color;
        g.setColor(new Color(Color));

        g.fillRect(xm * 5, ym * 5, 5, 5);
    }

    public boolean is(int a) {
        if (netVe == 0) {
            return true;

        } else if (netVe == 1) {
            if (a % 8 < 3 || a % 8 == 5) {
                return true;
            } else {
                return false;
            }

        } else if (netVe == 2) {
            if (a % 5 < 3) {
                return true;
            } else {
                return false;
            }
        } else if (netVe == 3) {
            if (a % 27 < 10 || a % 27 == 15 || a % 27 == 20) {
                return true;

            } else {
                return false;
            }
        } else if (netVe == 4) {
            return true;
        }
        return true;
    }

    void LineBres(int x1, int y1, int x2, int y2) {
        int dem = 0;
        int x, y, Dx, Dy, p;
        Dx = Math.abs(x2 - x1);
        Dy = Math.abs(y2 - y1);
        x = x1;
        y = y1;

        int xUnit = 1, yUnit = 1;

        if (x2 - x1 < 0)
            xUnit = -xUnit;
        if (y2 - y1 < 0)
            yUnit = -yUnit;

        list.add(new Point(x, y));


        if (Dx >= Dy) {
            p = 2 * Dy - Dx;

            while (x != x2) {
                if (p < 0) p += 2 * Dy;
                else {
                    p += 2 * (Dy - Dx);
                    y += yUnit;
                }
                x += xUnit;
                dem++;
                if (is(dem)) list.add(new Point(x, y));


            }
        } else {
            p = 2 * Dx - Dy;

            while (y != y2) {
                if (p < 0) p += 2 * Dx;
                else {
                    p += 2 * (Dx - Dy);
                    x += xUnit;
                }
                y += yUnit;

                if (is(dem)) list.add(new Point(x, y));


            }
        }

    }
}