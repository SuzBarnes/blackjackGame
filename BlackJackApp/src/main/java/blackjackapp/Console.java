package blackjackapp;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static java.lang.System.in;

public class Console {

    String askUser(){
        Scanner keyboard = new Scanner(in);
        return keyboard.nextLine();
    }

    void setAskUser(String input){
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        askUser();
    }

    public int askUserForInt(){
        Scanner keyboard = new Scanner(in);
        return keyboard.nextInt();
    }

    public double askUserForDouble(){
        Scanner keyboard = new Scanner(in);
        return keyboard.nextDouble();
    }

}
