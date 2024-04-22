package pl.dominik.IOService;

import java.util.Scanner;

public class PlayerInput {
    static Scanner scanner = new Scanner(System.in);

    public static int getIntFromPlayer() {
        try {
            return scanner.nextInt();
        } finally {
            scanner.nextLine();
        }
    }

}
