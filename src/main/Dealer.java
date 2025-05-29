package main;

import java.util.ArrayList;

public class Dealer extends Hand {

    public void dealInDealer(){
        hand = new ArrayList<>();
        createInitialHand();
        }

    public void ifDealerScoreLessThanOrEqualTo16Hit(){
        //dealer should only draw card once everyone else has finished their hands. Needs to check with Table that the players have finished.
        if(getPoints()<=16){
            hit(getDeck().get(0));
        }
    }
}
