package hu.vmatthias.foxandhounds.texts;

/**
 * Display Hound select text in the game.
 */
public class HoundSelectText {
    private String htext;

    public void sethtext(String htext) {
        this.htext = htext;
    }

    public void houndUnitSelect() {
        System.out.println(htext);
    }
}
