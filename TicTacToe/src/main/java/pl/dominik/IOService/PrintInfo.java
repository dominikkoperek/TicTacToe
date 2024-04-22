package pl.dominik.IOService;

import pl.dominik.TicTacToeService.TicTacToe;

public class PrintInfo {
    private final TicTacToe ticTacToe;

    public PrintInfo(TicTacToe ticTacToe) {
        this.ticTacToe = ticTacToe;
    }

    public  void printField() {
        System.out.println("|---|---|---|");
        System.out.println("| " + ticTacToe.getField()[0][0] + " | " + ticTacToe.getField()[0][1]
                + " | " + ticTacToe.getField()[0][2] + " | ");
        System.out.println("|---|---|---|");
        System.out.println("| " + ticTacToe.getField()[1][0] + " | " + ticTacToe.getField()[1][1]
                + " | " + ticTacToe.getField()[1][2] + " | ");
        System.out.println("|---|---|---|");
        System.out.println("| " + ticTacToe.getField()[2][0] + " | " + ticTacToe.getField()[2][1]
                + " | " + ticTacToe.getField()[2][2] + " | ");
        System.out.println("|---|---|---|");
    }
    public void printInfo(String text) {
        System.out.println(text);
    }
}
