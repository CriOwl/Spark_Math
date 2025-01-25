package Math_Spark.Games.diagnostic;

import java.util.Scanner;

public class Count {
    private final int a = 25, error = -1;
    private int state,main_number;
    private final int[][] matrix={
                        //number,+,-,_
                        {1,error,error,error},
                        {1,2,2,error},
                        {3,error,error,error},
                        {3,error,error,a},
    };
    private final String alphabet="+-_";
    public void game() {
        String word;
        String[] word_matrix=new String[4];
        for (int times = 0; times < 4; times++) {
            System.out.println("Enter the main number:");
        while (!Utilitary.keyboard.hasNextInt()) { 
            System.out.println("Enter a int number");
            Utilitary.keyboard.nextLine();
        }
        main_number=Utilitary.keyboard.nextInt();
        Utilitary.keyboard.nextLine();
            System.out.println("Enter the operations");
            word=Utilitary.keyboard.nextLine();
            if(validate(word)){
                String validationword=(operate_number(word)==main_number)?("\u001B[32m"+word+" = "+operate_number(word)+"\u001B[37m"):("\u001B[31m"+word+" = "+operate_number(word)+"\u001B[37m");
                    System.out.println(validationword);
            }else{
                System.out.println("\u001B[31m"+word+"La operacion no se puede realizar"+"\u001B[37m");
            }
            word_matrix[times]=word;
        }
        if(!validate_matrix(word_matrix)){
            System.out.println("La operacion no se puede concluir");
        } 
    }
    private boolean validate_matrix(String[] matrix){
        int number_correct=0;
        for (String matrix1 : matrix) {
            if (validate(matrix1)) {
                number_correct += (operate_number(matrix1) == main_number) ? 1 : 0;
            } else {
                return false;
            }
        }
        return number_correct==1;
    }

    private boolean validate (String validation){
        validation=validation.replaceAll(" ", "")+"_";
        state=0;
        for (int index_word = 0; index_word < validation.length(); index_word++) {
            state=validate_state(validation.charAt(index_word));
            if(state==error){
                return false;
            }
        }
        return state==a;
    }

    private int validate_state(char character){
        if(Character.isDigit(character)){
            return matrix[state][0];
        }
        for (int index_alphabet = 0; index_alphabet < alphabet.length(); index_alphabet++) {
            if(character==alphabet.charAt(index_alphabet)){
                return matrix[state][index_alphabet+1];
            }
        }
        return error;
    }

    private int operate_number(String operation){
        int number=0;
        try (Scanner separate = new Scanner(operation).useDelimiter("(?=[+-])")) {
            while (separate.hasNext()) {
                number+=separate.nextInt();
            }
        }
        return number;
    }

}
