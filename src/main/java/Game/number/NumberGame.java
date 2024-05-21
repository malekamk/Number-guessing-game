package Game.number;

import java.util.Scanner;
import java.util.Random;

public class NumberGame {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Random randomise = new Random();
        int randomNumber = randomise.nextInt(100) + 1;
        boolean result;
        int guessesleft = 10;
        int round = 2;

        do {

            try{
            String name = inPut("Guess the number between [1 to 100]? ");
            int userNumber = Integer.parseInt(name);


            if (userNumber < randomNumber) {
                System.out.println("Too LOW");
                result = true;guessesleft--;

            } else if (userNumber > randomNumber) {
                System.out.println("Too HIGH");
                result = true;guessesleft--;

            } else {
                System.out.println("YOU ARE CORRECT! THE NUMBER IS "+randomNumber );
                System.out.println("NEW GENERATED NUMBER!!");
                randomNumber = randomise.nextInt(100) + 1;
                result = true;guessesleft = 10;

            }

            }catch (NumberFormatException e){
                result =true;
            }
            System.out.println("NUMBER OF guessed left are: "+guessesleft );
            if (guessesleft == 0 ){
                String play = inPut("YOU wish to play again ?");
                if (play.equals("yes")){
                    System.out.println(" ROUND "+round++);
                    result = true;guessesleft = 10;}
            }

        } while (result);

        scanner.close();
    }

    private static String inPut(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}