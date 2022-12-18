package hu.vmatthias.foxandhounds.texts;

/**
 * Showing welcome text (Spring).
 */
public class WelcomeText {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public void welcome() {
        System.out.println("Welcome! You can choose from these commands: " + text);
    }
}
