package UserInterface.Customer_control;

import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class Mascaras extends DocumentFilter {
    private final int lengh=10;

    public int getLengh() {
        return lengh;
    }
    
        
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
            throws BadLocationException {
        if (string == null)
            return;
        if ((fb.getDocument().getLength() + string.length()) <= getLengh() && string.matches("\\d+")) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
            throws BadLocationException {
        if (text == null)
            return;
        if ((fb.getDocument().getLength() - length + text.length()) <= getLengh() && text.matches("\\d+")) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

}
