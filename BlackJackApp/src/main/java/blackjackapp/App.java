package blackjackapp;


public class App {
    public static void main(String[] args) {
        //play game should be how to start which leads to below being created

        Table table = new Table(new Dealer(), new Deck());
        table.start(1,1);
    }

}
