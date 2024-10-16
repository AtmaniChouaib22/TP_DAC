package data_race;

//class that implements Runnable interface to print character when the thread is started
public class CharacterPrinter implements Runnable {
    private char character;

    public CharacterPrinter(char character) {
        this.character = character;
    }
    // methode that will run when the thread is started
    @Override
    public void run() {
        System.out.print(character);
    }
}
