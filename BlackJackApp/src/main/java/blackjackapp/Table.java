package blackjackapp;

import java.util.ArrayList;


public class Table {
    Player player = new Player(new ArrayList<>(), 0,0,false, false,false);
    private ArrayList players = new ArrayList<>();
    private final Dealer dealer;
    private Deck deck;
    private double chips = player.getChips();

    public Table(Dealer dealer, Deck deck) {
        this.dealer = dealer;
        this.deck = deck;
    }

    public void setPlayer(Player player) {
        this.player = player;
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

    public void start(int numberOfPlayers, int numberOfHandsPerPlayer) {

        for (int i = 0; i < numberOfPlayers; i++) {

            if (i == 0) {
                dealer.dealInDealer();
            }
            player.setDeck(dealer.getDeck(), dealer.getCard());
            player.dealPlayerHand(numberOfHandsPerPlayer);

            players.add(player);

            assignWhoWinsAndPayout(numberOfHandsPerPlayer);
        }
    }

    void assignWhoWinsAndPayout(int numberOfHandsPerPlayer) {
        for(int j = 0; j< numberOfHandsPerPlayer; j++) {
            player.getHands().get(j).calculatePoints();
            setHasWon(j);
            evaluateWinnerAndPayout(j);
        }
    }

    public void setHasWon(int j) {
        Hand currentPlayerHand = player.getHands().get(j);
        int dealerPoints = dealer.getPoints();
        int playerPoints = currentPlayerHand.getPoints();

        if (dealer.hasBlackJack() && !currentPlayerHand.hasBlackJack()
                || currentPlayerHand.isBust()
                || dealerPoints > playerPoints && !dealer.isBust()) {
            dealer.setHasWon(true);
            currentPlayerHand.setHasWon(false);
        }
        if (player.hasBlackJack() && !dealer.hasBlackJack()
                || dealer.isBust()
                || playerPoints > dealerPoints && !currentPlayerHand.isBust()) {
            currentPlayerHand.setHasWon(true);
            dealer.setHasWon(false);
        }
       if(!dealer.hasBlackJack() &&
                !currentPlayerHand.isBust()
                && (dealerPoints < playerPoints || dealer.isBust())){
           currentPlayerHand.setHasWon(true);
           dealer.setHasWon(false);
       }

    }

    public void evaluateWinnerAndPayout(int j) {
        int bet = getPlayer().getHands().get(j).getBet();
        Hand playerCurrentHand = player.getHands().get(j);
        if (playerCurrentHand.isHasWon() && playerCurrentHand.hasBlackJack()) {
            chips =  chips + (bet * 2.5);
        }
        if (playerCurrentHand.isHasWon() && !playerCurrentHand.hasBlackJack()) {
            chips = chips + (bet * 2);
        }
        if (dealer.isHasWon() && !playerCurrentHand.isHasWon()) {
            chips = chips - bet;
        }
        player.setChips(chips);
    }
}
