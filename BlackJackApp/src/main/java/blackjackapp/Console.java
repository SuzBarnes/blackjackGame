package blackjackapp;

import org.mockito.internal.util.io.IOUtil;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.lang.System.in;

public class Console {

    String askUser() {
        Scanner keyboard = new Scanner(in);
        return keyboard.nextLine();
    }

    void setAskUser(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    public int askUserForInt() {
        Scanner keyboard = new Scanner(in);
        return keyboard.nextInt();
    }

    public double askUserForDouble() {
        Scanner keyboard = new Scanner(in);
        return keyboard.nextDouble();
    }

}
