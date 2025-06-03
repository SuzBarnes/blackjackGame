package blackjackapp;

import java.util.ArrayList;

public class Dealer extends Hand {

    ArrayList<Card> dealerHand = new ArrayList<>();
    public void dealInDealer(){
        createInitialHand();
        }

    public void ifDealerScoreLessThanOrEqualTo16Hit(){
        if(getPoints()<=16){
            hit(getDeck().get(0));
        }
    }
}
