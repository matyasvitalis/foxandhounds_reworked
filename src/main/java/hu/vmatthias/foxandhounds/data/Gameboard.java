package hu.vmatthias.foxandhounds.data;

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

    public static int getRow() {
        return row;
    }

    public static void setRow(int row) {
        Gameboard.row = row;
    }

    public static int getColumn() {
        return column;
    }

    public static void setColumn(int column) {
        Gameboard.column = column;
    }

    static int column;
}
