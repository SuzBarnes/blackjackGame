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

    String input = "";

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
            getInteractivePlay();
//            getFinalResults();
        }
    }

    void howMuchDoesPlayerBet(int noOfPlayers, int noOfHands) {
        for (int i = 0; i < noOfPlayers; i++) {
            for (int j = 0; j < noOfHands; j++) {
                out.println("How much would you like your bet to be for hand " + (i + 1) + "?");
                betPerHand = console.askUserForInt();
                table.getPlayers().get(i).getHands().get(j).setBet(betPerHand);
                table.getPlayers().get(i).calculateChipsRemaining(i);
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
        }
        atLeastOneHand(noOfHands);
        table.start(noOfPlayers, noOfHands);
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
    }

    void getInteractivePlay() {
        for (int i = 0; i < noOfHands; i++) {
            out.println("Your total Chips are: " + table.getPlayer().getChips());
            out.println("Your cards are: " + table.player.cards + "\nYour score is: " + table.player.getHands().get(i).getPoints());
            if (table.player.hasBlackJack()) {
                out.println("Congratulations, you have BlackJack");
                out.println("You win hand " + (i + 1) + "."); //TODO);
            }
            if (table.player.getHands().get(0).canBeSplit()) {
                out.println("Your chips are: " + table.player.getChips() + ".");
                out.println("Your initial bet for this hand was: " + table.player.getHands().get(i).getBet() + ".");
                out.println("Your cards can be split if you have enough coins.\nYour bet will be assigned to the split hand");
                out.println("Do you wish to split? Respond yes or no.");
                input = console.askUser().toLowerCase();
                while (!input.matches("yes") && !input.matches("no")) {
                    out.println("That wasn't a valid option. Do you want to split? Yes or no?");
                    input = console.askUser().toLowerCase();
                }
                if (input.matches("yes")) {
                    table.player.split();
                    noOfHands = noOfHands + 1;
                    out.println("Your chips are: " + table.player.getChips() + ".");
                    out.println("Your cards are: " + table.player.cards + "\nYour score is: " + table.player.getPoints());
                }
            }
            if (!table.player.hasBlackJack()) {
                out.println("Do you want to hit, or stick?");
                input = console.askUser().toLowerCase();
                while (!input.matches("hit") && !input.matches("stick")) {
                    out.println("That wasn't a valid option. Do you want to hit, or stick?");
                    input = console.askUser();
                }
                while (input.matches("hit")) {
                    table.player.hit();
                    out.println("Your cards are: " + table.player.cards + "\nYour score is: " + table.player.getPoints());
                    if (!table.player.getHands().get(i).isBust()) {
                        out.println("Do you want to hit, or stick?");
                        input = console.askUser().toLowerCase();
                    }
                }
            }
        }
    }

//    private void getFinalResults(){
//
//    }

    public void endGame() {
        gameEnded = true;
        out.println("Game ended.");
    }


}
