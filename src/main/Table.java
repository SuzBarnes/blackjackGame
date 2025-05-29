package main;

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


    public void start(int numberOfPlayers, int numberOfHandsPerPlayer) {

        for (int i = 0; i < numberOfPlayers; i++) {
                player = new Player();
                System.out.println("Player " + i +" created");

                if (i == 0) {
                    dealer.dealInDealer();
                }
                player.setDeck(dealer.getDeck());
                player.dealPlayerHand(numberOfHandsPerPlayer);
                System.out.println("player: " + player);
                players.add(getPlayer());

        }
    }
}
