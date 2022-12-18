package hu.vmatthias.foxandhounds;

import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import hu.vmatthias.foxandhounds.data.GameRules;
import hu.vmatthias.foxandhounds.data.Gameboard;
import hu.vmatthias.foxandhounds.texts.WelcomeText;
import hu.vmatthias.foxandhounds.xml.XmlLoad;
import hu.vmatthias.foxandhounds.xml.XmlSave;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
* Game initialization.
 */
public class Game {

    static String Fox = GameRules.getFox();
    static String Hound = GameRules.getHound();
    static String invalidMaze = GameRules.getInvalidMaze();
    static String freeMaze = GameRules.getFreeMaze();
    static String[][] shortTable = Gameboard.getShortTable();
    static int moveLimit = GameRules.getMoveLimit();
    static int row = Gameboard.getRow();
    static int column = Gameboard.getColumn();
    static String playround = "playround";
    static String save = "save";
    static String load = "load";
    static String exit = "exit";

    /**
     * Game starting.
     */

    public static void startGame() throws IOException, SQLException, ParserConfigurationException, TransformerException {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        WelcomeText welcometext = (WelcomeText) context.getBean("welcomeText");
        welcometext.Welcome();

        // Game start
        while (!GameRules.isFoxWinTrigger() || !GameRules.isFoxLoseTrigger()) {
            Scanner sc2 = new Scanner(System.in);
            String str2 = sc2.nextLine();
            if (str2.equals(playround)) {
                // First map check
                for (int i = 0; i < 8; i++) {
                    System.out.println(Arrays.deepToString(shortTable[i]));
                }
                // HOUND TURN
                // In this phase, you'll select your hound.
                System.out.println("Please select your hound(R/C[0-7]");
                BufferedReader rowReader = new BufferedReader(new InputStreamReader(System.in));
                row = Integer.parseInt(rowReader.readLine());
                BufferedReader columnReader = new BufferedReader(new InputStreamReader(System.in));
                column = Integer.parseInt(columnReader.readLine());

                while (row >= 8 || column >= 8) {
                    System.out.println("Too high numbers. Give new numbers.");
                    rowReader = new BufferedReader(new InputStreamReader(System.in));
                    row = Integer.parseInt(rowReader.readLine());
                    columnReader = new BufferedReader(new InputStreamReader(System.in));
                    column = Integer.parseInt(columnReader.readLine());
                }

                while (!shortTable[row][column].equals(Hound)) {
                    System.out.println("Wrong numbers. Please give new numbers!");
                    rowReader = new BufferedReader(new InputStreamReader(System.in));
                    row = Integer.parseInt(rowReader.readLine());
                    columnReader = new BufferedReader(new InputStreamReader(System.in));
                    column = Integer.parseInt(columnReader.readLine());
                }

                // HOUND MOVE
                // In this code, you should move your hound.
                System.out.println("Selected row: " + row);
                System.out.println("Selected column: " + column);
                System.out.println("Where do you want to move that?");
                BufferedReader houndRowMover = new BufferedReader(new InputStreamReader(System.in));
                int newRowPosition = Integer.parseInt(houndRowMover.readLine());
                BufferedReader houndColumnMover = new BufferedReader(new InputStreamReader(System.in));
                int newColumnPosition = Integer.parseInt(houndColumnMover.readLine());

                // Your new results:
                System.out.println("New row result: " + newRowPosition);
                System.out.println("New column result: " + newColumnPosition);

                // Check new data
                while (shortTable[newRowPosition][newColumnPosition].equals(invalidMaze) ||
                        shortTable[newRowPosition][newColumnPosition].equals(Hound) ||
                        newRowPosition > row + moveLimit ||
                        newColumnPosition > column + moveLimit) {
                    System.out.println("Invalid move. Please choose valid maze!");
                    houndRowMover = new BufferedReader(new InputStreamReader(System.in));
                    newRowPosition = Integer.parseInt(houndRowMover.readLine());
                    houndColumnMover = new BufferedReader(new InputStreamReader(System.in));
                    newColumnPosition = Integer.parseInt(houndColumnMover.readLine());
                }

                // Moving your hound
                shortTable[newRowPosition][newColumnPosition] = "H";
                shortTable[row][column] = freeMaze;
                row = newRowPosition;
                column = newColumnPosition;

                // if Fox can't move anymore
                if (shortTable[7][0].equals(Fox) && shortTable[6][1].equals(Hound) ||
                        shortTable[7][2].equals(Fox) && shortTable[6][1].equals(Hound) &&
                                shortTable[6][3].equals(Hound) ||
                        shortTable[7][4].equals(Fox) && shortTable[6][3].equals(Hound) &&
                                shortTable[6][5].equals(Hound) ||
                        shortTable[7][6].equals(Fox) && shortTable[6][5].equals(Hound) &&
                                shortTable[6][7].equals(Hound)) {
                    GameRules.setFoxLoseTrigger(true);
                    new FoxLose();
                }

                // Check map
                for (int i = 0; i < 8; i++) {
                    System.out.println(Arrays.deepToString(shortTable[i]));
                }

                // Selecting your Fox
                System.out.println("Please select your fox(R/C[0-7]");
                BufferedReader foxRowReader = new BufferedReader(new InputStreamReader(System.in));
                int foxRow = Integer.parseInt(foxRowReader.readLine());
                BufferedReader foxColumnReader = new BufferedReader(new InputStreamReader(System.in));
                int foxColumn = Integer.parseInt(foxColumnReader.readLine());

                // Check row/column, fox is here?
                while (!shortTable[foxRow][foxColumn].equals(Fox)) {
                    System.out.println("Wrong numbers. Please give new numbers!");
                    foxRowReader = new BufferedReader(new InputStreamReader(System.in));
                    foxRow = Integer.parseInt(foxRowReader.readLine());
                    foxColumnReader = new BufferedReader(new InputStreamReader(System.in));
                    foxColumn = Integer.parseInt(foxColumnReader.readLine());
                }

                // FOX MOVE
                System.out.println("Selected row: " + foxRow);
                System.out.println("Selected column: " + foxColumn);
                System.out.println("Where do you want to move that?");
                // FOX new row/column
                BufferedReader foxRowMover = new BufferedReader(new InputStreamReader(System.in));
                int newFoxRow = Integer.parseInt(foxRowMover.readLine());
                BufferedReader foxColumnMover = new BufferedReader(new InputStreamReader(System.in));
                int newFoxColumn = Integer.parseInt(foxColumnMover.readLine());
                // Check Fox new positions, these are right or not?
                while (shortTable[newFoxRow][newFoxColumn].equals(invalidMaze) ||
                        shortTable[newFoxRow][newFoxColumn].equals(Hound) ||
                        newFoxColumn > foxColumn + moveLimit ||
                        newFoxRow < foxRow - moveLimit) {
                    System.out.println("Invalid move. Please choose valid maze!");
                    foxRowMover = new BufferedReader(new InputStreamReader(System.in));
                    newFoxRow = Integer.parseInt(foxRowMover.readLine());
                    foxColumnMover = new BufferedReader(new InputStreamReader(System.in));
                    newFoxColumn = Integer.parseInt(foxColumnMover.readLine());
                }
                System.out.println("New fox row position: " + newFoxRow);
                System.out.println("New fox column position: " + newFoxColumn);

                // Moving your fox
                shortTable[newFoxRow][newFoxColumn] = "F";
                shortTable[foxRow][foxColumn] = freeMaze;

                // if Fox reaches Hound line
                for (int i = 0; i <= 7; i++) {
                    if (shortTable[0][i].equals(Fox)) {
                        new FoxWin();
                        GameRules.setFoxWinTrigger(true);
                    }
                }
            } else if (str2.equals(save)) {
                XmlSave.runCommand();
            } else if (str2.equals(load)) {
                XmlLoad.load();
            } else if (str2.equals(exit)) {
                exit(0);
            } else {
                System.out.println("Unknown command.");
            }
        }
    }
}