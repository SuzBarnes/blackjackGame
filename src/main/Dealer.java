package main;

public class Dealer extends Hand {
    private Hand hand;

    public void dealInDealer(){
        generateDeckShuffle();
        dealInitialHandAndRemoveCardsFromDeck();
    }
}
