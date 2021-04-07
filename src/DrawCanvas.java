import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

public class DrawCanvas extends JPanel {
    private List<PolyLine> lines = new ArrayList<PolyLine>();
    private PolyLine currentLine = new PolyLine();

    private CoordListener listener;
    private int netVe = 0;
    int dem = 0;

    public DrawCanvas(CoordListener listener) {
        this.listener = listener;

        this.setPreferredSize(new Dimension(950, 650));
        this.setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                currentLine.clear();
            }

            @Override
            public void mousePressed(MouseEvent e) {
//sww
//                lines.add(currentLine);
//                currentLine.addPoint(e.getX(), e.getY());
//              coordinates.setText("Toa do x: " + e.getX() + " y: " + e.getY());
//                Graphics g = getGraphics();
//                g.setColor(Color.BLUE);
//                currentLine.draw(g);
//                g.dispose();

            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
//                listener.change(e.getX() / 5, e.getY() / 5);
                listener.change(setPointX(e.getX()), setPointY(e.getY()));
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                Graphics g = getGraphics();

                currentLine.clearLine(g);
                currentLine.clearList();
//                currentLine.addPoint(e.getX() / 5, e.getY() / 5);
                currentLine.addPoint(setPointX(e.getX()), setPointY(e.getY()));
//                g.setColor(Color.BLUE);
                currentLine.draw(g);
                currentLine.clearList();
                g.dispose();



            }
        });

    }

    public void setNetVe(int x) {
        netVe = x;
        currentLine.setNetVe(netVe);
    }

    public int setPointX(int x) {
        int point = -190 / 2 + x / 5;
        return point;
    }

    public int setPointY(int y) {
        int point = 130 / 2 - y / 5;
        return point;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        g.setColor(Color.RED);
    }

}
