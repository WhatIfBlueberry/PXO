import CyberWirtzLib.CyberWirtz;
import CyberWirtzLib.CyberWirtzFactory;
import CyberWirtzLib.Fields;
import CyberWirtzLib.Matrix;


public class Main {
    public static void main(String[] args) {
        CyberWirtzFactory factory = new CyberWirtzFactory();
        CyberWirtz wirtz = factory.generate(Fields.REAL);
        double marks[][]={{50,60,55,67,70},{62,65,70,70,81},{72,66,77,80,69}};
        Matrix matrix = new Matrix(marks);
        System.out.println(matrix.);
        System.out.println("================================");
        System.out.println(matrix.transpose());
    }
}