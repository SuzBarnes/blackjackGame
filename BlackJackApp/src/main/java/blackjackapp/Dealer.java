package blackjackapp;


import java.util.ArrayList;

import static java.lang.System.out;

public class Dealer extends Hand {
    private boolean hasWon = false;

    public Dealer(ArrayList<Card> cards, int points, int bet, boolean isBust, boolean hasBlackJack, boolean canBeSplit) {
        super(cards, points, bet, isBust, hasBlackJack, canBeSplit);
    }

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
            out.println("Dealer has " + getPoints() +
                    " points.\nDealer has to draw again. ");
            hit();
            out.println("Dealer has " + getPoints() +
                    " points.");
            if(isBust()){
                out.println("Dealer is bust.");
            }
        }
    }
}
