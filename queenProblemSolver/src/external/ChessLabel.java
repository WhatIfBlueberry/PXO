package external;

import javax.swing.*;
import java.awt.*;


public class ChessLabel extends JLabel {
    Color bgLight = new Color(222, 184, 135);
    Color bgDark = new Color(139, 69, 19);

    ChessLabel(String s) {
        super(s);
    }

    void set(int idx, int row, int boardSize) {
        if (boardSize % 2 == 1) {
            row = 0;
        }
        Font font = new Font("Ariel", Font.PLAIN, 60);
        setFont(font);
        setOpaque(true);
        setBackground((idx + row) % 2 == 0 ? bgDark : bgLight);
        setHorizontalAlignment(SwingConstants.CENTER);
    }

}