package hu.vmatthias.foxandhounds.texts;

public class WelcomeText {
    private String text;

    public void setText(String text)
    {
        this.text = text;
    }
    public void Welcome(){
        System.out.println("Welcome! You can choose from these commands: " + text);
    }

}
