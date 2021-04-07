import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MyFrame extends JFrame implements CoordListener {
    private JPanel rootPaint;
    private JButton hcn;
    private JButton ChooseColor;
    private JButton netdut;
    private JPanel mainPaint;
    private JButton chamrach;
    private JLabel coordinates;
    private JButton haichamrach;
    private JButton muiten;
    DrawCanvas canvas;
    private int colorRGB;
    private List<PolyLine> lines;
    private PolyLine currentLine;
    private List<Integer> x = new ArrayList<>();

    public MyFrame() {
        this.setSize(1100, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        canvas = new DrawCanvas(this);
        currentLine = new PolyLine(this);
        lines = new ArrayList<>();
        ChooseColor.addActionListener(e -> {
            Color color = JColorChooser.showDialog(null, "Choose Color", ChooseColor.getBackground());
            if (color != null) {
                ChooseColor.setBackground(color);
                colorRGB = color.getRGB();
            }
        });
        chamrach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setNetVe(1);
            }
        });
        netdut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setNetVe(2);
            }
        });
        haichamrach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setNetVe(3);
            }
        });
        hcn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setNetVe(4);
            }
        });
        muiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setNetVe(5);
            }
        });
        this.mainPaint.add(canvas);
        this.add(rootPaint);
        this.pack();
    }

    @Override
    public void change(int x, int y) {
        coordinates.setText("x: " + x + " - y:" + y);
    }

    @Override
    public void changeColor(int color) {
        color = colorRGB;
    }
}
