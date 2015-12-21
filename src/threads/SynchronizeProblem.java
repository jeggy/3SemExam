package threads;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jógvan 21/12-2015 18:06.
 */
/*
 * Det her program laver 10 objekter med hvert sit egen thread.
 * Hvert Thread kører en metode som kører en loop på 100.000 gange og plusser en static variabel med 1.
 * Når Threadet er færdigt at køre 100.000 gange joiner vi det thread med main thread igen.
 *
 * Vi ville forvente at 10 threads der kører 100.000 gange hvert ville give 1.000.000
 * men operativ systemet giver nogle interrupts, så det er ikke hver gang at det register bliver
 * gemt i ram'et efter der er tilføjet 1 i det registor.
 *
 * LK-CPU kode:
 *      LOAD
 *      INC R1
 *      STORE [rd], R1
 *
 * Det vil så betyde at interrupt ville kunne komme mellem INC og STORE instructionerne.
 * Når operativ systemet skifter thread mellem INC og STORE, vil den gå et bag ud
 * fordi den ikke bliver gemt før den skifter og når det andet thread har kørt ville det
 * første thread køre sin STORE med et tal som ikke har det tal fra det andet thread.
 * Så den gemmer det samme tal som var der før.
 *
 */


// vi extender Thread, så vi kan ha flere threads(processer) kørende
public class SynchronizeProblem implements Runnable {

    static int counter = 0;

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new SynchronizeProblem()));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Oh shit, join thread did not work!");
                e.printStackTrace();
            }
        }

        System.out.println("All threads finished ok.");
    }

    public void run() {
        workCounter();
    }

    private void workCounter() {
        for (int i = 1; i <= 100000; i++) {
            counter++;
        }

        System.out.println(Thread.currentThread().getName() + " is done. Overall executed times: " + counter);
    }
}