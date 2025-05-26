import java.util.Scanner;

public class Wasee10rNot {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        String word;
        boolean yep, nope;

        System.out.println("Type teh word\"weasel\",please.");
        word = keyboard.next();
        yep = word.equals("weasel");
        nope =! word.equals("weasel");

        System.out.println("You typed what was requested: " + yep);
        System.out.println("You ignored polite instructions" + nope);
    }
}
