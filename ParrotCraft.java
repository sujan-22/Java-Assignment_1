//@Author: Sujan Rokad, 000882948

import java.util.*;

public class ParrotCraft {
    public static void main(String[] args) {
//        getting inputs from user to name parrots and defining three new parrots p1, p2, p3
        Scanner input = new Scanner(System.in);
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

//        While loop for outputs and keep running the code

        while (true) {
            System.out.println(p1.toString());
            System.out.println(p2.toString());
            System.out.println(p3.toString());
            System.out.println("1.FEED 2.COMMAND 3.PLAY 4.HIT 5.QUIT");
            System.out.println("Select one option from above");

//        Creating option variable to save input for choice of interface from the menu

            int option;
            option = input.nextInt();
            if (option == 5)
                break;
            System.out.println("Which Parrot?");
            int p = input.nextInt();

//        Introducing new variable called selectedParrot to save value of user's selected choice of parrot
//        using switch method to rerun all the method

            Parrot selectedParrot = new Parrot();
            switch (p) {
                case 1: selectedParrot = p1;
                break;
                case 2: selectedParrot = p2;
                break;
                case 3: selectedParrot = p3;
                break;
                default:
                    System.out.println("Choose valid Parrot");
                    continue;
            }

//            4 switch cases for 4 type of menu interface (feed, play, hit, command)

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
                    if (selectedParrot.alive_dead == "dead") {
                        System.out.println("A dead parrot cannot feed");
                    }
                    else {
                        System.out.println("Which parrot do you want to play");
                        int parrotPlay = input.nextInt();
                        if (parrotPlay==p) {
                            System.out.println("Parrot cannot play with itself");
                            continue;
                        }
                        else if (parrotPlay==1) {
                            System.out.println(selectedParrot.play(p1));
                        }
                        else if (parrotPlay==2){
                            System.out.println(selectedParrot.play(p2));
                        }
                        else if (parrotPlay==3) {
                            System.out.println(selectedParrot.play(p3));
                        }
                    }
                    break;
                case 4:
                    System.out.println(selectedParrot.hit());
                    break;
                default:
                    System.out.println("Select valid choice");
            }
        }


    }


}
