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
            player.setDeck(dealer.getDeck(), dealer.getCard());
            player.dealPlayerHand(numberOfHandsPerPlayer);
            players.add(getPlayer());
            doesPlayerWin();

        }
    }

    public boolean doesPlayerWin() {
        int dealerPoints = dealer.getPoints();
        int dealerHandSize = dealer.getCards().size();
        int playerPoints = player.getPoints();

        if (dealer.isBlackJack(dealerPoints, dealerHandSize) ||
                player.isBust()
                || dealerPoints >= playerPoints && !dealer.isBust()) {
            return false;
        }
        return true;
    }

}
