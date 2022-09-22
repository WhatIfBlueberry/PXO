package com.wib.cyberwirtzlib.math;

import com.wib.cyberwirtzlib.cyberwirtzimpl.ComplexCyberWirtz;
import com.wib.cyberwirtzlib.cyberwirtzimpl.CyberWirtz;
import com.wib.cyberwirtzlib.cyberwirtzimpl.RealCyberWirtz;

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
