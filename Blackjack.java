import java.util.Scanner;

import java.text.DecimalFormat;

public class Blackjack {                //Changes for Lab04 GitHub check

    public static void main(String[] args) {

        P1Random rng = new P1Random(); //Generates predetermined "random numbers"

        int gameNum = 1; //Declare variables

        int selection = 1;

        int myHand;

        int myWin = 0;

        int gameTie = 0;

        int dealerWin = 0;

        String strNumber;

        Scanner scan = new Scanner(System.in);

        do {                                                     //Outer loop for new game
            System.out.println("START GAME #" + gameNum);

            gameNum = gameNum + 1;

            myHand = 0;

            do {                                                //Second loop for hit
                int myNumber = rng.nextInt(13) + 1;

                if (myNumber == 1) {                            //Convert numbers to face card name and value

                    strNumber = "ACE";

                } else if (myNumber == 11) {

                    myNumber = 10;

                    strNumber = "JACK";

                } else if (myNumber == 12) {

                    myNumber = 10;

                    strNumber = "QUEEN";

                } else if (myNumber == 13) {

                    strNumber = "KING";

                    myNumber = 10;

                } else {

                    strNumber = Integer.toString(myNumber);                             //Convert Int to String
                }                                                                       //Bozhidar Bozhanov
                                                                                        //Date:2011
                myHand = myHand + myNumber;                                             //Availablilty: Stackoverflow.com

                System.out.println("Your card is a " + strNumber + "!" +

                        "\nYour hand is: " + myHand);

                if (myHand == 21) {

                    System.out.println("BLACKJACK! You win!");

                    myWin = myWin + 1;

                }

                if (myHand > 21) {

                    System.out.println("You exceeded 21! You lose.");

                    dealerWin = dealerWin + 1;

                }
                do {
                    if (myHand > 20) {                              //Skip menu and deal cards for bust and blackjack

                        break;

                    }
                    boolean flag1 = false;

                    System.out.println("1.  Get another card\n" +

                            "2.  Hold hand\n" +

                            "3.  Print statistics\n" +

                            "4.  Exit");

                    System.out.println("Choose an option:");

                    selection = scan.nextInt();

                    if (selection == 2) {                           //Deal cards for dealer for stand

                        int dealNum = rng.nextInt(11) + 16;

                        System.out.println("Dealer's hand: " + dealNum);

                        System.out.println("Your hand is: " + myHand);

                        if (dealNum > 21 || dealNum < myHand) {     //Criteria for stand

                            System.out.println("You win!");

                            myWin = myWin + 1;

                            myHand = 0;

                        } else if (dealNum == myHand) {

                            System.out.println("It's a tie! No one wins!");

                            gameTie = gameTie + 1;

                            myHand = 0;

                        } else {

                            System.out.println("Dealer wins!");

                            dealerWin = dealerWin + 1;

                            myHand = 0;
                        }

                    }

                    if (selection == 3) {                           //Stats

                        gameNum = gameNum - 2;                      //Correct game count for stat

                        System.out.println("Number of Player wins: " + myWin);

                        System.out.println("Number of Dealer wins: " + dealerWin);

                        System.out.println("Number of tie games: " + gameTie);

                        System.out.println("Total # of games played is: " + gameNum);

                        float percentWin = (float) myWin;           //Calculate win percentage

                        percentWin = (percentWin / gameNum) * 100;

                        DecimalFormat df = new DecimalFormat("0.0");

                        System.out.println("Percentage of Player wins: " + df.format(percentWin) + "%");

                        gameNum = gameNum + 2;                       //Revert game count

                        selection = 6;                               //Change selection to return to menu

                        flag1 = true;

                    }

                    if (selection == 4) {

                        System.exit(0);

                    }
                    if (((selection < 1) || (selection > 4)) && (!flag1)) {

                        System.out.println("Invalid input! \nPlease enter an integer value between 1 and 4.");
                    }
                }

                while ((selection < 1) || (selection > 4));             //Returns to menu for selection

            }

            while ((selection == 1) && (myHand != 0) && (myHand < 21)); //Returns to top of second loop for card

        }

        while ((selection == 1) || (selection == 2));                   //Returns to top of outer loop for new game

    }


}