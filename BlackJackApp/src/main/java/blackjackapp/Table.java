package blackjackapp;

import java.util.ArrayList;

public class Table {
    private Player player = new Player();
    private ArrayList players = new ArrayList<>();
    private Dealer dealer;
    private Deck deck;

    public Table(Dealer dealer, Deck deck) {
        this.dealer = dealer;
        this.deck = deck;
    }

    public Player getPlayer() {
        return player;
    }


    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Dealer getDealer() {
        return dealer;
    }


    public ArrayList<Player> getPlayers() {
        return players;
    }

    // could change numberOfHandsPerPlayer and set it as an input in the console instead
    public void start(int numberOfPlayers, int numberOfHandsPerPlayer) {

        for (int i = 0; i < numberOfPlayers; i++) {
            player = new Player();

            if (i == 0) {
                dealer.dealInDealer();
            }
            player.setDeck(dealer.getDeck());
            player.dealPlayerHand(numberOfHandsPerPlayer);
            players.add(getPlayer());
            doesPlayerWin();

        }
    }

    public boolean doesPlayerWin() {
        int dealerPoints = dealer.getPoints();
        int dealerHandSize = dealer.getHand().size();
        int playerPoints = player.getPoints();

        if (dealer.isBlackJack(dealerPoints, dealerHandSize) ||
                player.isBust()
                || dealerPoints >= playerPoints) {
            return false;
        }
        return true;
    }
        // need to evaluate who if you win, win with blackjack, lose or draw.
        // if you win, win double bet, win with blackjack win 2.5x bet, lose - lose bet, draw return bet.
        // will then need to apply to multiple hands

//        player.bet(playerBetOfHand);
//        int chips;
        //can you split??
        //points = X
        // cards in hand = X, X
        // do you want to hit or stick?

        // first check isBlackjack. Then check isDraw, then check does player win, then does dealer win...?

        // separate method for payout would be better depending on what is true in evaluate



//        if (player.getPoints() > dealer.getPoints()) {
//            //player wins double bet
//            return playerBetOfHand * 2;
//        }
//        if (player.getPoints() == dealer.getPoints()) {
//            return playerBetOfHand;
//        }
//        if (dealer.isBlackJack(dealer.getPoints(), dealer.getHand().size()) && !player.isBlackJack(player.getPoints(), player.getHand().size())) {
//            return playerBetOfHand * -1;
//        }
//        if (player.getPoints() < dealer.getPoints()) {
//            return playerBetOfHand * -1;
//        }
//        if (player.isBust()) {
//            return playerBetOfHand * -1;
//        }
//        if (dealer.isBust() && !player.isBust()) {
//            return playerBetOfHand * 2;
//        }
//        if (dealer.isBust() && player.isBust()) {
//            return playerBetOfHand;
//        }
//        if (!dealer.isBlackJack(dealer.getPoints(), dealer.getHand().size()) && player.isBlackJack(player.getPoints(), player.getHand().size())) {
//            return playerBetOfHand * 2.5;
//        }
//        return;

        //if both have blackjack how does the bet return work??
        // need to do some bool methods - if(dealerWins){return playerbetofhand * -1}
        // if(playerWins){return Blah}
        // if player wins with blackjack
        // if neither win, give cash back....
        // find out how to work it so each hand can have a set bet.
//


}
