package hu.vmatthias.foxandhounds;

import org.springframework.context.annotation.Bean;

/**
*   Gameboard values, settings.
*/
public class Gameboard {
    @Bean
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
