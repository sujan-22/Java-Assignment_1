/**
 * Author:                 Sujan Rokad, 000882948
 * Authorship statement:   I, Sujan Rokad, 000882948, certify that this material is my original work.
 *                         No other person's work has been used without due acknowledgement.
 * Purpose:                Simulate a ParrotCraft program where users can interact with parrots.
 */

import java.util.Scanner;

public class ParrotCraft {

    /**
     * The main method of the ParrotCraft program.
     *
     * @param args The command-line arguments (unused).
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Creating three parrots and getting names from the user
        Parrot p1 = new Parrot();
        Parrot p2 = new Parrot();
        Parrot p3 = new Parrot();

        System.out.println("Enter name for Parrot 1");
        String parrot1 = input.next();
        System.out.println("Enter name for Parrot 2");
        String parrot2 = input.next();
        System.out.println("Enter name for Parrot 3");
        String parrot3 = input.next();

        p1.setName(parrot1);
        p2.setName(parrot2);
        p3.setName(parrot3);

        // Interaction loop with the parrots
        while (true) {
            System.out.println(p1.toString());
            System.out.println(p2.toString());
            System.out.println(p3.toString());
            System.out.println("1.FEED 2.COMMAND 3.PLAY 4.HIT 5.QUIT");
            System.out.println("Select one option from above");

            int option;
            option = input.nextInt();
            if (option == 5)
                break;

            System.out.println("Which Parrot?");
            int p = input.nextInt();

            Parrot selectedParrot;
            switch (p) {
                case 1: selectedParrot = p1;
                        break;
                case 2: selectedParrot = p2;
                        break;
                case 3: selectedParrot = p3;
                        break;
                default:
                    System.out.println("Choose a valid Parrot");
                    continue;
            }

            switch (option) {
                case 1:
                    System.out.println("How much do you want to feed?");
                    double food = input.nextDouble();
                    System.out.println(selectedParrot.feed(food));
                    break;
                case 2:
                    System.out.println("Fly or Stay");
                    String flying = input.next();
                    System.out.println(selectedParrot.command(flying));
                    break;
                case 3:
                    if ("dead".equals(selectedParrot.alive_dead)) {
                        System.out.println("A dead parrot cannot play");
                    } else {
                        System.out.println("Which parrot do you want to play");
                        int parrotPlay = input.nextInt();
                        if (parrotPlay == p) {
                            System.out.println("Parrot cannot play with itself");
                            continue;
                        } else if (parrotPlay == 1) {
                            System.out.println(selectedParrot.play(p1));
                        } else if (parrotPlay == 2) {
                            System.out.println(selectedParrot.play(p2));
                        } else if (parrotPlay == 3) {
                            System.out.println(selectedParrot.play(p3));
                        }
                    }
                    break;
                case 4:
                    System.out.println(selectedParrot.hit());
                    break;
                default:
                    System.out.println("Select a valid choice");
            }
        }
    }
}
