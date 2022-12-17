package hu.vmatthias.foxandhounds;

/**
 * Basic rules.
 */
public class GameRules {

    public static String getFox() {
        return Fox;
    }

    public static void setFox(String fox) {
        Fox = fox;
    }

    public static String getHound() {
        return Hound;
    }

    public static void setHound(String hound) {
        Hound = hound;
    }

    public static String getInvalidMaze() {
        return invalidMaze;
    }

    public static void setInvalidMaze(String invalidMaze) {
        GameRules.invalidMaze = invalidMaze;
    }

    public static String getFreeMaze() {
        return freeMaze;
    }

    public static void setFreeMaze(String freeMaze) {
        GameRules.freeMaze = freeMaze;
    }

    public static String getPlayerName() {
        return playerName;
    }

    public static String setPlayerName() {
        return playerName;
    }

    public static int getPlayerWinMatches() {
        return playerWinMatches;
    }

    public static int setPlayerWinMatches() {
        return playerWinMatches;
    }

    // Values settings
    static String Fox = "F";
    static String Hound = "H";
    static String invalidMaze = "-";
    static String freeMaze = "*";
    // Player properties
    static String playerName;
    static int playerWinMatches = 0;
    static boolean foxWinTrigger = false;
    static boolean foxLoseTrigger = false;
    static int moveLimit = 1;

    public static boolean isFoxWinTrigger() {
        return foxWinTrigger;
    }

    public static void setFoxWinTrigger(boolean foxWinTrigger) {
        GameRules.foxWinTrigger = foxWinTrigger;
    }

    public static boolean isFoxLoseTrigger() {
        return foxLoseTrigger;
    }

    public static void setFoxLoseTrigger(boolean foxLoseTrigger) {
        GameRules.foxLoseTrigger = foxLoseTrigger;
    }

    public static int getMoveLimit() {
        return moveLimit;
    }

    public static void setMoveLimit(int moveLimit) {
        GameRules.moveLimit = moveLimit;
    }
}
