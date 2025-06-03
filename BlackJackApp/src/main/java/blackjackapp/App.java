package blackjackapp;


public class App {
    public static void main(String[] args) {
        //play game should be how to start which leads to below being created
//       ArrayList<Card> deck = org.Deck.generateDeck();
        Deck deck = new Deck();
        deck.generateDeck();
        System.out.println();
    }

}
