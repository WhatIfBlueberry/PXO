import CyberWirtzLib.CyberWirtz;
import CyberWirtzLib.CyberWirtzFactory;
import CyberWirtzLib.Fields;
import CyberWirtzLib.Matrix;


public class Main {
    public static void main(String[] args) {
        CyberWirtzFactory factory = new CyberWirtzFactory();
        CyberWirtz wirtz = factory.generate(Fields.REAL);
    }
}