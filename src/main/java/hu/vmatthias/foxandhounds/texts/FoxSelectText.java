package hu.vmatthias.foxandhounds.texts;

/**
 * Display Fox select text in the game.
 */
public class FoxSelectText {
    String ftext;

    public void setftext(String ftext) {
        this.ftext = ftext;
    }

    public void foxUnitSelect() {
        System.out.println(ftext);
    }
}
