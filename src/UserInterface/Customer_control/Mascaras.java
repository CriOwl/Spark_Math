package UserInterface.Customer_control;
import javax.swing.text.*;
public class Mascaras extends DocumentFilter {
    private final int lengh;

    public Mascaras(int lengh) {
        this.lengh=lengh;
    }


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
    public static boolean validate_DNI(String DNI){
        if(DNI.length()==10){
            int two_digits=Integer.parseInt(DNI.substring(0, 2));
            System.out.println(two_digits);
            if( two_digits<=24 && two_digits>=0&& Character.getNumericValue(DNI.charAt(2))<7){
                int result=0;
                int resto=0;
                for (int i = 0; i < DNI.length()-1; i++) {
                  result=(Character.getNumericValue(DNI.charAt(i)))*((i%2==0)?2:1);
                  resto+=((result>=10)?result-9:result);
                }
                if(resto%10==0){
                    return ((Character.getNumericValue(DNI.charAt(9)))==(resto%10));
                }else{
                    return 10-(resto%10)==(Character.getNumericValue(DNI.charAt(9)));
                }
            }
        }
        return false;
    }

}
