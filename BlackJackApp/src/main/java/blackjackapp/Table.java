package blackjackapp;

import java.util.ArrayList;

public class Table {

    private Player player = new Player();
    private ArrayList players = new ArrayList<>();
    private final Dealer dealer;
    private Deck deck;
    private int chips = player.getChips();
    private int bet = player.getBet();

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
            setHasWon();
            evaluateWinnerAndPayout();
        }
    }

    //create hasWon on the what's it called. If both hasWon is false, then it is a draw
    // if dealer wins check for blackjack - need to check if blackjack before anything and assign dealer/player has won.
    // if player wins, check for blackjack
    public boolean doesPlayerWin() {
        int dealerPoints = dealer.getPoints();
        int playerPoints = player.getPoints();

        return !dealer.hasBlackJack() &&
                !player.isBust()
                && (dealerPoints < playerPoints || dealer.isBust());
    }

    public void setHasWon() {
        int dealerPoints = dealer.getPoints();
        int playerPoints = player.getPoints();

        if (dealer.hasBlackJack() && !player.hasBlackJack()
                || player.isBust()
                || dealerPoints > playerPoints) {
            dealer.setHasWon(true);
            player.setHasWon(false);
        }
        if (player.hasBlackJack() && !dealer.hasBlackJack()
                || dealer.isBust()
                || playerPoints > dealerPoints) {
            player.setHasWon(true);
            dealer.setHasWon(false);
        }

    }

    public void evaluateWinnerAndPayout(){

        if(player.isHasWon() && player.hasBlackJack()){
            chips = (int) (chips + (getPlayer().getBet() * 2.5));
        }
        if(player.isHasWon()){
            chips = chips + (getPlayer().getBet() * 2);
        }
        if(dealer.isHasWon()){
            chips = chips -getPlayer().getBet();
        }
        if(!player.isHasWon() && !dealer.isHasWon()){
            chips = chips + getPlayer().getBet();
        }
    }


}
