package main;

public class Dealer extends Hand {

    public void dealInDealer(){
        System.out.println("dealInDealer(), need to double check that this is removed from the same deck as the players deck.");
        System.out.println("deal all players then dealInDealer()");

        createInitialHand();
    }

    public void ifDealerScoreLessThanOrEqualTo16Hit(){
        //dealer should only draw card once everyone else has finished their hands. Needs to check with Table that the players have finished.
        if(getPoints()<=16){
            hit(getDeck().get(0));
        }
    }
}
