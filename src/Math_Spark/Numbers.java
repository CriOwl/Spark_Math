package Math_Spark;

public class Numbers {
    private Integer main_number;
    private int[] number=new int[2];
    private final int error = -1;

    public void game() {
        System.out.println("Enter the main_number");
        while (!Utilitary.keyboard.hasNextInt()) {
            System.out.println("Enter a int number");
            Utilitary.keyboard.nextLine();
        }
        main_number = Utilitary.keyboard.nextInt();
        Utilitary.keyboard.nextLine();
        for (int index = 0; index < 2; index++) {
            System.out.println("Enter the number");
            while (!Utilitary.keyboard.hasNextInt()) {
                System.out.println("Enter a int number");
                Utilitary.keyboard.nextLine();
            }
            number[index] = Utilitary.keyboard.nextInt();
            Utilitary.keyboard.nextLine();
        }
        if (validate(main_number, number[0], number[1]) == error) {
            System.out.println("The number 1 and the number 2 has the same distance from the main number");
        }
        else{
            System.out.println("\u001B[32m"+validate(main_number, number[0], number[1])+"\u001B[37m");
        }
    }

    private int validate(int main_number, int number_1, int number_2) {
        if (Math.abs(main_number - number_1) == Math.abs(main_number - number_2)) {
            return error;
        } else if (Math.abs(main_number - number_1) > Math.abs(main_number - number_2)) {
            return number_2;
        }
        return number_1;
    }
    public int randomise_up(int main_number){
        return main_number+(int)(Math.random()*25+1);
    }
    public int randomise_under(int main_number){
        return main_number-(int)(Math.random()*25+1);
    }

}
