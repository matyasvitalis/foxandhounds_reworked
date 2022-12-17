package hu.vmatthias.foxandhounds;

import java.io.IOException;
import java.sql.SQLException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 * Program starting.
 */
public class Main {
    public static void main(String[] args) throws SQLException, IOException, ParserConfigurationException,
            TransformerException {
            Game.startGame();
    }
}



