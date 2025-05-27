package main;

public class Dealer extends Hand {

    public void dealInDealer(){
        System.out.println("dealInDealer(), need to double check that this is removed from the same deck as the players deck.");
        createInitialHand();
        ifDealerScoreLessThanOrEqualTo16Hit();
    }

    private void ifDealerScoreLessThanOrEqualTo16Hit(){
        if(getPoints()<=16){
            hit(getDeck());
        }
    }
}
