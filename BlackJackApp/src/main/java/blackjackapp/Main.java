package blackjackapp;


public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        //play game should be how to start which leads to below being created
        main.run();
    }

    int noOfPlayers = 1;
    int noOfHands = 1;
    double betPerHand;
    Dealer dealer = new Dealer();
    Deck deck = new Deck();
    Table table = new Table(dealer, deck);

    public void run() {
        Console console = new Console();
        System.out.println("Hello & welcome to the Casino!");
        System.out.println("How many Players are here?");
        noOfPlayers = console.askUserForInt();
        if (noOfPlayers <= 0) {
            endGame();
        }
        if (noOfPlayers == 1) {
            System.out.println("Just you? No problem!");
            System.out.println("How many hands would you like to have?");
            noOfHands = console.askUserForInt();
            if (noOfHands <= 0) {
                System.out.println("I'm sorry you don't feel like playing today.");
                endGame();
            }
            if (noOfHands >= 1) {
                if (noOfHands == 1) {
                    System.out.println("That's great. Dealer will deal you " + noOfHands + " hand.");
                } else {
                    System.out.println("That's great. Dealer will deal you " + noOfHands + " hands.");
                }
                table.start(noOfPlayers, noOfHands);

            }
        }
            if (noOfPlayers > 1) {
                System.out.println("Perfect.");
                System.out.println("How many hands would you like each Player to have?");
                noOfHands = console.askUserForInt();

                if (noOfHands <= 0) {
                    System.out.println("I'm sorry you don't feel like playing today.");
                    endGame();
                }
                if (noOfHands >= 1) {
                    if (noOfHands == 1) {
                        System.out.println("That's great. Dealer will deal " + noOfHands + " hand to each Player.");
                    } else {
                        System.out.println("That's great. Dealer will deal " + noOfHands + " hands to each Player.");
                    }
                    table.start(noOfPlayers, noOfHands);
                    // TODO be able to set different hands for different players
//            for(int i = 0; i<noOfPlayers; i++) {
//                System.out.println("How many hands would Player " + i+1 + " like to have?");
                }
                // TODO have different bets for different players
                System.out.println("How much would you like your bet to be per hand?");
                betPerHand = console.askUserForDouble();
                // TODO check there is enough in the purse
                System.out.println("That is great.");
                System.out.println("Lets play!");


            }
    }

    public void endGame() {
        System.out.println("Game ended.");
    }



}
