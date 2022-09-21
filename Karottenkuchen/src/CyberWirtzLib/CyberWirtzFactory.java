package CyberWirtzLib;

public class CyberWirtzFactory {

    /**
     * @param field
     * @return CyberWirtz Matrix calculator that works for all Elements in given field
     * @see CyberWirtz
     */
    public CyberWirtz generate(Fields field) {
        return field.getCyberWirtz();
    }

}

