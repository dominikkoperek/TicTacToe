package pl.dominik.TicTacToeService;

import pl.dominik.IOService.PlayerInput;
import pl.dominik.IOService.PrintInfo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    private static final String DRAW = "Draw";
    PrintInfo printInfo = new PrintInfo(this);
    PlayerBuilder playerCreate = new PlayerBuilder(printInfo);
    private  String field[][] = new String[3][];
    private String playerX;
    private String playerO;
    private String actualPlayer;
    private  final String X = "\uD835\uDC17";
    private  final String O = "\uD835\uDDE2";
    private String winner = "nowinner";
    Scanner scanner = new Scanner(System.in);

    public  String[][] getField() {
        return field;
    }

    public void createField() {
        field[0] = new String[]{"1", "2", "3"};
        field[1] = new String[]{"4", "5", "6"};
        field[2] = new String[]{"7", "8", "9"};
    }

    public void play() {
        createField();
        getPlayersNames();
        printInfo.printField();
        setFieldWithXorO();
    }

    private void getPlayersNames() {
        playerCreate.getPlayersName();
        playerX = playerCreate.getNameX();
        playerO = playerCreate.getNameO();
        setFirstMovePlayer();
    }

    private void setFirstMovePlayer() {
        boolean hasGoodPlayerChosen = false;
        while (!hasGoodPlayerChosen) {
            printInfo.printInfo("Who move first X or O ? ");
            String chosenFirstMove = String.valueOf(scanner.nextLine().toUpperCase().charAt(0));
            switch (chosenFirstMove) {
                case "X" -> {
                    hasGoodPlayerChosen = true;
                    actualPlayer = playerX;
                }
                case "O" -> {
                    hasGoodPlayerChosen = true;
                    actualPlayer = playerO;
                }
                default -> {
                    printInfo.printInfo("Wrong player!");
                    printInfo.printInfo("X or O");

                }
            }
        }
        printInfo.printInfo(actualPlayer + " Starting!");
    }

    private String setXorO() {
        return actualPlayer.equals(playerX) ? X : O;
    }


    private void setFieldWithXorO() {
        while (winner.equals("nowinner")) {
            int playerChoice = 0;
            try {
                playerChoice = PlayerInput.getIntFromPlayer();
            } catch (InputMismatchException e) {
                printInfo.printInfo("Try number 1-9!");
                playerChoice = PlayerInput.getIntFromPlayer();
            }
            switch (playerChoice) {

                case 1 -> {
                    if (field[0][0].equals("1")) {
                        field[0][0] = setXorO();
                    } else {
                        fieldTakenMess();
                    }
                }
                case 2 -> {
                    if (field[0][1].equals("2")) {
                        field[0][1] = setXorO();
                    } else {
                        fieldTakenMess();
                    }
                }
                case 3 -> {
                    if (field[0][2].equals("3")) {
                        field[0][2] = setXorO();
                    } else {
                        fieldTakenMess();
                    }
                }
                case 4 -> {
                    if (field[1][0].equals("4")) {
                        field[1][0] = setXorO();
                    } else {
                        fieldTakenMess();
                    }
                }
                case 5 -> {
                    if (field[1][1].equals("5")) {
                        field[1][1] = setXorO();
                    } else {
                        fieldTakenMess();
                    }
                }
                case 6 -> {
                    if (field[1][2].equals("6")) {
                        field[1][2] = setXorO();
                    } else {
                        fieldTakenMess();
                    }
                }
                case 7 -> {
                    if (field[2][0].equals("7")) {
                        field[2][0] = setXorO();
                    } else {
                        fieldTakenMess();
                    }
                }
                case 8 -> {
                    if (field[2][1].equals("8")) {
                        field[2][1] = setXorO();
                    } else {
                        fieldTakenMess();
                    }
                }
                case 9 -> {
                    if (field[2][2].equals("9")) {
                        field[2][2] = setXorO();
                    } else {
                        fieldTakenMess();
                    }
                }
                default -> {
                    printInfo.printInfo("Try number from 1-9!");
                    setFieldWithXorO();

                }
            }
            checkForWin();
            if (winner.equals("nowinner")) {
                sayTurn();
                swapTeams();
                printInfo.printField();
            }
        }
        printInfo.printField();
    }


    private void fieldTakenMess() {
        printInfo.printInfo("Field is taken!");
        printInfo.printInfo("Try again " + actualPlayer);
        printInfo.printField();
        setFieldWithXorO();
    }

    private void sayTurn() {
        printInfo.printInfo(actualPlayer.equals(playerX) ? " _Now_ " + playerO : " _Now_ " + playerX);
    }

    private void swapTeams() {
        if (actualPlayer.equals(playerX)) {
            actualPlayer = playerO;
        } else {
            actualPlayer = playerX;
        }
    }

    private void checkForWin() {
        for (int i = 0; i < 8; i++) {
            String line = "";
            switch (i) {
                case 0 -> line = field[0][0] + field[0][1] + field[0][2];
                case 1 -> line = field[1][0] + field[1][1] + field[1][2];
                case 2 -> line = field[2][0] + field[2][1] + field[2][2];
                case 3 -> line = field[0][0] + field[1][0] + field[2][0];
                case 4 -> line = field[0][1] + field[1][1] + field[2][1];
                case 5 -> line = field[0][2] + field[1][2] + field[2][2];
                case 6 -> line = field[0][0] + field[1][1] + field[2][2];
                case 7 -> line = field[2][0] + field[1][1] + field[0][2];

            }
            if (line.equals(X + X + X)) {
                winner = playerX;
                printInfo.printInfo(winnerMessage());
                break;
            } else if (line.equals(O + O + O)) {
                winner = playerO;
                printInfo.printInfo(winnerMessage());
                break;
            }
        }
        checkDraw();

    }

    private void checkDraw() {
        boolean hasNumbers = false;
        for (String[] strings : field) {
            for (String string : strings) {
                if (string.matches("[1-9]")) {
                    hasNumbers = true;
                    break;
                }
            }
        }
        if (!hasNumbers && winner.equals("nowinner")) {
            winner = DRAW;
            printInfo.printInfo(winnerMessage());
        }
    }

    private String winnerMessage() {
        return "___The Winer is___" + "\n" + winner;

    }
}
