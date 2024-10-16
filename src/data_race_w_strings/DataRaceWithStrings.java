package data_race_w_strings;

//a class that holds a shared data (shared string) that the threads will share
public class DataRaceWithStrings {

    public String sharedString = "initial";
    //method to append strings to the shared data(sharedString)
    public void appendToSharedString(String toAppend) {
        sharedString += toAppend;
    }
}