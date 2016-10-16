import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by patrickert on 10/11/16.
 */
public class RegressionGUI {

    private Regression r;
    private JPanel p;
    private JFrame frame;
    private final static int HEIGHT = 800;
    private final static int WIDTH = 600;
    private double[] xValues;
    private double[] yValues;
    private double b0Value;
    private double b1Value;
    private double sigmaSquareValue;
    private double rSquareValue;
    private double sxxValue;
    private double sxyValue;
    private double syyValue;

    public RegressionGUI(){
        r = new Regression();
        frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("Linear Regression");

        frame.setSize(WIDTH, HEIGHT);

        initialize();
    }

    private void initialize(){


        p = new JPanel();

        p.setLayout(new GridLayout(5,1));
        frame.add(p);

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

        xLabel.setVisible(true);
        yLabel.setVisible(true);
        x.setVisible(true);
        y.setVisible(true);
        calculate.setVisible(true);

        frame.revalidate();
        frame.repaint();


    }
    private void menu() {

        frame.getContentPane().removeAll();
        p = new JPanel();
        frame.add(p);
        p.setLayout(new GridLayout(9,1));
        JButton sxx = new JButton("Show Sxx");
        JButton sxy = new JButton("Show Sxy");
        JButton syy = new JButton("Show Syy");
        JButton b0 = new JButton("Show b0");
        JButton b1 = new JButton("Show b1");
        JButton sigmaSquare = new JButton("Show sigma square");
        JButton rSquare = new JButton("Show r square");
        JButton startAgain = new JButton("Start Again");

        p.add(sxx);
        p.add(sxy);
        p.add(syy);
        p.add(b0);
        p.add(b1);
        p.add(sigmaSquare);
        p.add(rSquare);
        p.add(startAgain);


        sxx.addActionListener((ActionEvent) -> sxx());
        sxy.addActionListener((ActionEvent) -> sxy());
        syy.addActionListener((ActionEvent) -> syy());
        b0.addActionListener((ActionEvent) -> b0());
        b1.addActionListener((ActionEvent) -> b1());
        sigmaSquare.addActionListener((ActionEvent) -> sigmaSquare());
        rSquare.addActionListener((ActionEvent) -> rSquare());
        startAgain.addActionListener((ActionEvent) -> {
                    frame.getContentPane().removeAll();
                    initialize();
                });


        sxx.setVisible(true);
        sxy.setVisible(true);
        syy.setVisible(true);
        b0.setVisible(true);
        b1.setVisible(true);
        sigmaSquare.setVisible(true);
        rSquare.setVisible(true);
        startAgain.setVisible(true);



        frame.revalidate();
        frame.repaint();


    }

    private void sxx() {

        frame.getContentPane().removeAll();
        p = new JPanel();
        p.setLayout(new FlowLayout());
        JLabel value = new JLabel(sxxValue+" ");
        JButton menu = new JButton("Menu");
        frame.add(p);
        frame.setTitle("Sxx");
        p.add(menu);
        p.add(value);
        menu.addActionListener((ActionEvent)->menu());
        menu.setVisible(true);
        p.setVisible(true);

        frame.revalidate();
        frame.repaint();

    }

    private void sxy() {

        frame.getContentPane().removeAll();
        p = new JPanel();
        p.setLayout(new FlowLayout());
        JLabel value = new JLabel(sxyValue+" ");
        JButton menu = new JButton("Menu");
        frame.add(p);
        frame.setTitle("Sxy");
        p.add(menu);
        p.add(value);
        menu.addActionListener((ActionEvent)->menu());
        menu.setVisible(true);
        p.setVisible(true);

        frame.revalidate();
        frame.repaint();

    }

    private void syy() {

        frame.getContentPane().removeAll();
        p = new JPanel();
        p.setLayout(new FlowLayout());
        JLabel value = new JLabel(syyValue+" ");
        JButton menu = new JButton("Menu");
        frame.add(p);
        frame.setTitle("Syy");
        p.add(menu);
        p.add(value);
        menu.addActionListener((ActionEvent)->menu());
        menu.setVisible(true);
        p.setVisible(true);

        frame.revalidate();
        frame.repaint();

    }


    private void sigmaSquare() {

        frame.getContentPane().removeAll();
        p = new JPanel();
        p.setLayout(new FlowLayout());
        JLabel value = new JLabel(sigmaSquareValue+" ");
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
        sxxValue = r.sxx(xValues);
        sxyValue = r.sxy(xValues, yValues);
        syyValue = r.sxx(yValues);
        b0Value = r.b0(xValues, yValues);
        b1Value = r.b1(xValues, yValues);
        sigmaSquareValue = r.sigma2(yValues, r.estimation(xValues, b0Value, b1Value));
        rSquareValue = r.r2(yValues, r.estimation(xValues, b0Value, b1Value));
        menu();
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
