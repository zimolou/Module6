import java.util.Scanner;

public class AgeMessages {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        int age;

        System.out.print("How old are you?");
        age = keyboard.nextInt();

        System.out.println("You are: ");
        if(age < 13){
            System.out.println("\ttoo young to create a Facebook account");
        }
        if(age < 16){
            System.out.println("\ttoo young to get a driver's license");
        }
        if(age < 18){
            System.out.println("\ttoo young to get a tattoo");
        }
        if(age < 21){
            System.out.println("\ttoo young to drink alcohol");
        }
        if(age < 35){
            System.out.println("\ttoo young to run for President of the U.S.");
            System.out.println("\t\t(How sad!)");
        }
    }
}
