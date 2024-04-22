package pl.dominik.TicTacToeService;

import pl.dominik.IOService.PrintInfo;

import java.util.Scanner;

public class PlayerBuilder {
    private final PrintInfo printInfo;
    private String nameX;
    private String nameO;
    Scanner sc = new Scanner(System.in);

    public PlayerBuilder(PrintInfo printInfo) {
        this.printInfo = printInfo;
    }

    public String getNameX() {
        return nameX;
    }

    public void setNameX(String nameX) {
        this.nameX = nameX;
    }

    public String getNameO() {
        return nameO;
    }

    public void setNameO(String nameO) {
        this.nameO = nameO;
    }

    public void getPlayersName() {
        printInfo.printInfo("Player X type your name: ");
        setNameX(sc.nextLine() + "(X)");
        printInfo.printInfo("Player O type your name: ");
        setNameO(sc.nextLine()+ " (O)");

    }

}
