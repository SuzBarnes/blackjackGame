package blackjackapp;


import java.util.ArrayList;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        //play game should be how to start which leads to below being created
        main.run();
    }

    int noOfPlayers = 1;
    int noOfHands = 1;
    int betPerHand;
    Dealer dealer = new Dealer(new ArrayList<>(), 0, 0, false, false, false);

    Deck deck = new Deck();
    Table table = new Table(dealer, deck);
    Console console = new Console();
    boolean gameEnded = false;

    public void run() {
        out.println("Hello & welcome to the Casino!");
        out.println("How many Players are here?");
        noOfPlayers = console.askUserForInt();
        if (noOfPlayers <= 0) {
            endGame();
        } else {
            onePlayer();
            moreThanOnePlayer(noOfPlayers);
            howMuchDoesPlayerBet(noOfPlayers, noOfHands);
            // TODO check there is enough in the purse
            out.println("That is great.");
            out.println("Lets play!");
        }
    }

    void howMuchDoesPlayerBet(int noOfPlayers, int noOfHands) {
        for (int i = 0; i < noOfPlayers; i++) {
            for (int j = 0; j < noOfHands; j++) {
                out.println("How much would you like your bet to be for hand " + i + 1 + "?");
                betPerHand = console.askUserForInt();
                table.getPlayers().get(i).getHands().get(j).setBet(betPerHand);
            }
        }
    }

    void moreThanOnePlayer(int noOfPlayers) {
        if (noOfPlayers > 1) {
            out.println("Perfect.");
            out.println("How many hands would you like each Player to have?");
            noOfHands = console.askUserForInt();

            numberOfHands();

        }
    }

    private void numberOfHands() {
        if (noOfHands <= 0) {
            out.println("I'm sorry you don't feel like playing today.");
            endGame();
        } else {
            atLeastOneHand(noOfHands);
        }
    }

    void onePlayer() {
        out.println("onePlayer");
        out.println("Just you? No problem!");
        out.println("How many hands would you like to have?");
        noOfHands = console.askUserForInt();
        numberOfHands();
    }

    void atLeastOneHand(int noOfHands) {

        if (noOfHands == 1) {
            out.println("That's great. Dealer will deal you " + noOfHands + " hand.");
        } else {
            out.println("That's great. Dealer will deal you " + noOfHands + " hands.");
        }
        table.start(noOfPlayers, noOfHands);

    }

    public void endGame() {
        gameEnded = true;
        out.println("Game ended.");
    }


}
