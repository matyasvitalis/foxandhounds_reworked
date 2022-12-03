package hu.vmatthias.foxandhounds;

import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Objects;

/**
 * Program starting.
 */
public class Main {
        // 8x8 board initialization
        static String[][] shortTable = {
                {"-", "H", "-", "H", "-", "H", "-", "H"},
                {"*", "-", "*", "-", "*", "-", "*", "-"},
                {"-", "*", "-", "*", "-", "*", "-", "*"},
                {"*", "-", "*", "-", "*", "-", "*", "-"},
                {"-", "*", "-", "*", "-", "*", "-", "*"},
                {"*", "-", "*", "-", "*", "-", "*", "-"},
                {"-", "*", "-", "*", "-", "*", "-", "*"},
                {"F", "-", "*", "-", "*", "-", "*", "-"},
        };
        // Values settings
        static String Fox = "F";
        static String Hound = "H";
        static String invalidMaze = "-";
        static String freeMaze = "*";
        // Player properties
        static String playerName;
        static int playerWinMatches = 0;
        /**
     *
     *
     * Game starting.
     *
     */

        public static void main(String[] args) throws IOException, SQLException {

            // Game rules
            boolean foxWinTrigger = false;
            boolean foxLoseTrigger = false;
            int moveLimit = 1;

            // Game start
            while (!foxWinTrigger || !foxLoseTrigger) {

                // First map check
                for (int i = 0; i < 8; i++) {
                    System.out.println(Arrays.deepToString(shortTable[i]));
                }

                // HOUND TURN
                // In this phase, you'll select your hound.
                System.out.println("Please select your hound(R/C[0-7]");
                BufferedReader rowReader = new BufferedReader(new InputStreamReader(System.in));
                int row = Integer.parseInt(rowReader.readLine());
                BufferedReader columnReader = new BufferedReader(new InputStreamReader(System.in));
                int column = Integer.parseInt(columnReader.readLine());

                if (row >= 8 || column >= 8) {
                    throw new ArrayIndexOutOfBoundsException("Too high numbers");
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
                    foxLoseTrigger = true;
                    foxLose();
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
                foxRow = newFoxRow;
                foxColumn = newFoxColumn;

                // if Fox reaches Hound line
                for (int i = 0; i <= 7; i++) {
                    if (shortTable[0][i].equals(Fox)) {
                        foxWinTrigger = true;
                        foxWin();
                    }
                }
            }
        }

        public static void foxLose() {
            System.out.println("You lost the match.");
            exit(0);
        }
        /**
     *If the fox wins, this code will be happening.
     *
     */

        public static void foxWin() throws SQLException, IOException {
            System.out.println("You win!");
            System.out.println("Please write your Player name to store your high score.");
            BufferedReader playerNameReader = new BufferedReader(new InputStreamReader(System.in));
            playerName = playerNameReader.readLine();
            playerWinMatches = playerWinMatches + 1;
            Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/./FoxandHounds", "sa", "fox123");
            Statement statement = connection.createStatement();
            String selectSQL = "SELECT playername, score  FROM HIGHSCORE" +
                    " WHERE playername='" + playerName + "'";
            String dbPlayerName = null;
            int dbScore = 0;
            ResultSet rs1 = statement.executeQuery(selectSQL);
            while (rs1.next()) {
                dbPlayerName = rs1.getString("playername");
                dbScore = rs1.getInt("score");
                dbScore = dbScore + playerWinMatches;
            }
                if (Objects.equals(dbPlayerName, playerName)) {
                String updateSQL = "UPDATE HIGHSCORE " + "SET score='" + dbScore + "'WHERE playername='" + dbPlayerName + "'";
                statement.executeUpdate(updateSQL);
                } else {
                String saveScore = "INSERT INTO HIGHSCORE VALUES(DEFAULT, '" + playerName + "', '" + playerWinMatches + "')";
                statement.executeUpdate(saveScore);
                }

            // High score loader
            String loadScoreBoard = "SELECT id, playerName, score FROM HIGHSCORE ";
            ResultSet rs2 = statement.executeQuery(loadScoreBoard);
            { while (rs2.next()) {
                System.out.println("ID: " + rs2.getInt("id"));
                System.out.println("Player name: " + rs2.getString("playername"));
                System.out.println("Wins: " + rs2.getInt("score") + "\n");
            }
            }
            statement.close();
            connection.close();
            exit(0);
        }
    }

