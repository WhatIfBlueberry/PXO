package cyberwirtzlib.math;

import cyberwirtzlib.ComplexCyberWirtz;
import cyberwirtzlib.CyberWirtz;
import cyberwirtzlib.RealCyberWirtz;

public enum Fields {
    REAL(new RealCyberWirtz()),
    COMPLEX(new ComplexCyberWirtz());

    CyberWirtz cyberWirtz;

    Fields(CyberWirtz cyberWirtz) {
        this.cyberWirtz = cyberWirtz;
    }

    public CyberWirtz getCyberWirtz() {
        return this.cyberWirtz;
    }
}
