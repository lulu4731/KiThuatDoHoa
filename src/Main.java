import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            // Run the GUI codes on the Event-Dispatching thread for thread safety
            @Override
            public void run() {
                new MyFrame(); // Let the constructor do the job
            }
        });
    }
//        MyFrame f = new MyFrame();
////        f.setVisible(true);
//    }
}
