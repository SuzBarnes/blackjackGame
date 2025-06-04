package blackjackapp;


public class Dealer extends Hand {
    private boolean hasWon = false;

    public boolean isHasWon() {
        return hasWon;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }


    public void dealInDealer() {
        createInitialHand();
        ifDealerScoreLessThanOrEqualTo16Hit();
    }

    public void ifDealerScoreLessThanOrEqualTo16Hit() {
        if (getPoints() <= 16) {
            System.out.println("Dealer has " + getPoints() +
                    " points.\nDealer has to draw again. ");
            hit();
        }
    }
}
