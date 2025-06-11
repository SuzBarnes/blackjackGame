package blackjackapp;


import java.util.ArrayList;


public class Dealer extends Hand {

    public Dealer(ArrayList<Card> cards, int points, int bet, boolean hasBlackJack, boolean isBust, boolean canBeSplit) {
        super(cards, points, bet, hasBlackJack, isBust, canBeSplit);
    }

    private boolean hasWon = false;

    @Override
    public boolean isHasWon() {
        return hasWon;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public void dealInDealer() {
        createInitialHand();
        // TODO need to show just one hand to player that dealer has.
        //  Only when player has finished should the remaining card(s) be shown
        ifDealerScoreLessThanOrEqualTo16Hit();
    }

    public void ifDealerScoreLessThanOrEqualTo16Hit() {
        if (getPoints() <= 16) {
            hit();
        }
    }
}
