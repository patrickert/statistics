/**
 * Created by patrickert on 10/10/16.
 */
public class Regression {


    public double average(double[] vector){
        double result = 0;
        for (int i = 0; i <vector.length ; i++) {
            result+=vector[i];
        }
        return  result/vector.length;
    }


    public double sxy(double[] x, double[] y){
        double result = 0;
        double avgX = average(x);
        double avgY = average(y);

        for (int i = 0; i < x.length; i++) {
            result+= (x[i] - avgX)*(y[i] - avgY);
        }

        return result;
    }

    public double sxx(double[] vector){
        double result = 0;
        double avg = average(vector);
        for (int i = 0; i <vector.length ; i++) {
            result+= Math.pow(vector[i] - avg, 2);
        }
        return result;
    }



    public double b1(double[] x, double[] y){
        return sxy(x,y)/sxx(x);
    }

    public double b0(double[] x, double[] y){
        return average(y) - b1(x, y)*average(x);
    }

    public double sse(double[] real, double[] estimation){
        double result = 0;
        for (int i = 0; i < real.length; i++) {
            result+=Math.pow(real[i] - estimation[i], 2);
        }
        return result;
    }

    public double sigma2(double[] real, double[] estimation){
        return sse(real, estimation)/ (real.length-2);
    }
    public double[] estimation(double[] x, double b0, double b1){
        double[] result = new double[x.length];
        for (int i = 0; i <x.length ; i++) {
            result[i] = b0 + b1*x[i];
        }
        return result;
    }

    public double r2(double[] real, double[] estimation){
        return 1 - (sse(real, estimation))/sxx(real);
    }


}
