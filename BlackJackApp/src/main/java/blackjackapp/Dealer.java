package blackjackapp;

import java.util.ArrayList;

public class Dealer extends Hand {

    public void dealInDealer(){
        createInitialHand();
        ifDealerScoreLessThanOrEqualTo16Hit();
        }

    public void ifDealerScoreLessThanOrEqualTo16Hit(){
        if(getPoints()<=16){
            System.out.println("Dealer has " + getPoints() + " points.\nDealer has to draw again. ");
            hit();
        }
    }
}
