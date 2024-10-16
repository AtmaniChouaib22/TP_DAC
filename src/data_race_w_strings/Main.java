package data_race_w_strings;

import java.util.concurrent.locks.Lock ;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        //to control access to the shared data
        //Lock lock = new ReentrantLock() ;

        DataRaceWithStrings dataRace = new DataRaceWithStrings();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // Lock to ensure only one thread accesses the shared string at a time
                //lock.lock();
                dataRace.appendToSharedString(" World");
                //always unlock after the lock
                //lock.unlock();


            }
        });

        Thread thread2 = new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                //lock.lock();
                dataRace.appendToSharedString(" hello");
                //lock.unlock();
            }
        });
        //start both threads
        thread1.start();
        thread2.start();

        //wait for both threads
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final string: " + dataRace.sharedString);
    }
}

//tp notes
/*
we try to simulate a data race situation, we see that the result is not as expected,
the threads are trying to access the same data(sharedString) and modify it which is (append to sharedString)
so they block each other, resulting the output to not be completed
to fix the data race problem we should control the threads access to the shared data using lock and unlock
 */