import cyberwirtzlib.CyberWirtz;
import cyberwirtzlib.CyberWirtzFactory;
import cyberwirtzlib.Fields;
import cyberwirtzlib.Matrix;


public class Main {
    public static void main(String[] args) {
        CyberWirtzFactory factory = new CyberWirtzFactory();
        CyberWirtz wirtz = factory.generate(Fields.REAL);
        double[][] a = {{1, 2, 3, 4}, {5, 6, 7, 3}};
        double[][] q = {{1, 2, 3, 4}, {5, 6, 7, 7}};
        double[][] w = {{1, 2, 3, 4}, {5, 6, 3, 7}};
        double[][] e = {{1, 2, 2, 4}, {5, 4, 7, 1}};
        double[][] f = {{1, 3, 2, 4}, {5, 4, 7, 1}};

        System.out.println(wirtz.add(new Matrix(a), new Matrix(q), new Matrix(w), new Matrix(e), new Matrix(f)));
    }
}