import com.wib.cyberwirtzlib.cyberwirtzimpl.CyberWirtz;
import com.wib.cyberwirtzlib.cyberwirtzimpl.CyberWirtzFactory;
import com.wib.cyberwirtzlib.math.ComplexNumber;
import com.wib.cyberwirtzlib.math.Fields;

public class Main {
    public static void main(String[] args) {
        TestHelper helper = new TestHelper();
        helper.addTwoMatrices();
        helper.addMultipleMatrices();
        helper.addTwoComplexMatrices();
        helper.addMultipleComplexMatrices();
        System.out.println(new ComplexNumber(2,3));
        CyberWirtzFactory factory = new CyberWirtzFactory();
        CyberWirtz reellerAlgorithmus = factory.generate(Fields.REAL);
        helper.testMultiply();
    }
}