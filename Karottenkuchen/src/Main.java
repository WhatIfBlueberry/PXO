import cyberwirtzlib.CyberWirtz;
import cyberwirtzlib.CyberWirtzFactory;
import cyberwirtzlib.Fields;
import cyberwirtzlib.Matrix;


public class Main {
    public static void main(String[] args) {
        CyberWirtzFactory factory = new CyberWirtzFactory();
        CyberWirtz wirtz = factory.generate(Fields.REAL);
        double[][] myNumbers = {{1, 2, 3, 4}, {5, 6, 7, 3}};
        double[][] myNumbers2 = {{1, 2, 3, 4}, {5, 6, 7, 7}};
        System.out.println(wirtz.add(new Matrix(myNumbers), new Matrix(myNumbers2)));
    }
}