package data_race;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String phrase = "Hi World!";
    //iteration over the String
        for (int i = 0; i < phrase.length(); i++) {
            //get the character at index(i) position
            char character = phrase.charAt(i);
            //create a new thread for each character usin the class data_race.CharacterPrinter
            Thread thread = new Thread(new CharacterPrinter(character));
            thread.start(); //start the thread which will invoke the method run of data_race.CharacterPrinter
        }
    }
}

//TP Notes:
// we got the characters in a messed order because we cannot predict thread execution order
//A data race occurs in a multithreaded or concurrent program when two or more threads access shared data at the same time,
// and at least one of the threads is modifying the data leading to unpredictable behavior.
// Data races typically happen when there is no proper synchronization between threads.