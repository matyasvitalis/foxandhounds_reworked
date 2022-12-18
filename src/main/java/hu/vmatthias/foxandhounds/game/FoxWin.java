package hu.vmatthias.foxandhounds.game;

import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import hu.vmatthias.foxandhounds.data.GameRules;

/**
 * When Fox wins the round.
 */
public class FoxWin {
        String playerName;
        int playerWinMatches;
     String dbPlayerName = null;
        int dbScore = 0;

    public FoxWin() throws SQLException, IOException {
        playerName = GameRules.getPlayerName();
        playerWinMatches = GameRules.getPlayerWinMatches();
        System.out.println("You win!");
        System.out.println("Please write your Player name to store your high score.");
        BufferedReader playerNameReader = new BufferedReader(new InputStreamReader(System.in));
        playerName = playerNameReader.readLine();
        playerWinMatches = playerWinMatches + 1;
        Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/./FoxandHounds", "sa", "fox123");
        Statement statement = connection.createStatement();
        String selectSQL = "SELECT playername, score  FROM HIGHSCORE" +
                " WHERE playername='" + playerName + "'";
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
        {
            while (rs2.next()) {
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

