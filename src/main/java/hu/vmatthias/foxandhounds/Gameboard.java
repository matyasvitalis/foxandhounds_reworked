package hu.vmatthias.foxandhounds;

/**
*   Gameboard values, settings.
*/
public class Gameboard {

    public static String[][] getShortTable() {
        return shortTable;
    }

    public static void setShortTable(String[][] shortTable) {
        Gameboard.shortTable = shortTable;
    }

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

    static int row;
    static int column;
}
