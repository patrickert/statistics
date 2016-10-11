import javax.swing.*;
import java.awt.*;

/**
 * Created by patrickert on 10/11/16.
 */
public class RegressionGUI {

    private Regression r;
    private JPanel p;
    private JFrame frame;
    private JButton b0, b1, sigmaSquare, rSquare;
    private final static int HEIGHT = 800;
    private final static int WIDTH = 600;
    private double[] xValues;
    private double[] yValues;
    private double b0Value;
    private double b1Value;
    private double sigmaSquareValue;
    private double rSquareValue;

    public RegressionGUI(){
        r = new Regression();
        frame = new JFrame();
        frame.setVisible(true);

        menu();
    }
    private void menu() {

        frame.getContentPane().removeAll();
        p = new JPanel();
        frame.add(p);
        p.setLayout(new GridLayout(9,1));
        b0 = new JButton("Show b0");
        b1 = new JButton("Show b1");
        sigmaSquare = new JButton("Show sigma square");
        rSquare = new JButton("Show r square");


        p.add(b0);
        p.add(b1);
        p.add(sigmaSquare);
        p.add(rSquare);



        b0.addActionListener((ActionEvent) -> b0());
        b1.addActionListener((ActionEvent) -> b1());
        sigmaSquare.addActionListener((ActionEvent) -> sigmaSquare());
        rSquare.addActionListener((ActionEvent) -> rSquare());

        b0.setVisible(true);
        b1.setVisible(true);
        sigmaSquare.setVisible(true);
        rSquare.setVisible(true);

        frame.setTitle("Linear Regression");

        frame.setSize(WIDTH, HEIGHT);

        if(xValues == null || yValues == null){

            JLabel xLabel = new JLabel("Enter x values:");
            JLabel yLabel = new JLabel("Enter y values:");

            TextField x = new TextField();
            TextField y = new TextField();
            JButton calculate = new JButton("Calculate");

            p.add(xLabel);
            p.add(x);
            p.add(yLabel);
            p.add(y);
            p.add(calculate);



            calculate.addActionListener((ActionEvent) -> calculate(x, y));


        }



        frame.revalidate();
        frame.repaint();


    }


    private void sigmaSquare() {

        frame.getContentPane().removeAll();
        p = new JPanel();
        p.setLayout(new FlowLayout());
        JLabel value = new JLabel(xValues == null ? "Please go back to Menu and fill vectors" : sigmaSquareValue+" ");
        JButton menu = new JButton("Menu");
        frame.add(p);
        frame.setTitle("Sigma Square");
        p.add(menu);
        p.add(value);
        menu.addActionListener((ActionEvent)->menu());
        menu.setVisible(true);
        p.setVisible(true);

        frame.revalidate();
        frame.repaint();

    }

    private void b1() {

        frame.getContentPane().removeAll();
        p = new JPanel();
        p.setLayout(new FlowLayout());
        JLabel value = new JLabel(xValues == null? "Please go back to Menu and fill vectors": b1Value+" ");
        JButton menu = new JButton("Menu");
        frame.add(p);
        frame.setTitle("B1");
        p.add(menu);
        p.add(value);
        menu.addActionListener((ActionEvent)->menu());
        menu.setVisible(true);
        p.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }

    private void b0() {

        frame.getContentPane().removeAll();
        p = new JPanel();
        p.setLayout(new FlowLayout());
        JLabel value = new JLabel(xValues == null? "Please go back to Menu and fill vectors":b0Value+" ");
        JButton menu = new JButton("Menu");
        frame.add(p);
        frame.setTitle("B0");
        p.add(menu);
        p.add(value);
        menu.addActionListener((ActionEvent)->menu());
        menu.setVisible(true);
        p.setVisible(true);
        frame.revalidate();
        frame.repaint();

    }

    private void calculate(TextField x, TextField y){
        xValues = parse(x.getText().split(" "));
        yValues = parse(y.getText().split(" "));
        b0Value = r.b0(xValues, yValues);
        b1Value = r.b1(xValues, yValues);
        sigmaSquareValue = r.sigma2(yValues, r.estimation(xValues, b0Value, b1Value));
        rSquareValue = r.r2(yValues, r.estimation(xValues, b0Value, b1Value));
    }

    private double[] parse(String [] s){
        double[] result = new double[s.length];
        for (int i = 0; i < s.length; i++) {
            result[i] = Double.parseDouble(s[i]);
        }
        return result;
    }



    private void rSquare() {

    frame.getContentPane().removeAll();

        p = new JPanel();
        p.setLayout(new FlowLayout());
        JLabel value = new JLabel(xValues == null? "Please go back to Menu and fill vectors" : rSquareValue+" ");
        JButton menu = new JButton("Menu");
        frame.add(p);
        frame.setTitle("R Square");
        p.add(menu);
        p.add(value);
        menu.addActionListener((ActionEvent)->menu());
        menu.setVisible(true);
        p.setVisible(true);
        frame.revalidate();
        frame.repaint();

    }
}
