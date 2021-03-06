package com.company;

public class Program {

    public static final int threadCount_ = 10;
    public static final int iterationCount_ = 1000000;
    public static void main(String[] args) {
        final StatsCounter c = new StatsCounter();


        // Set up the threads
        Thread[] threads = new Thread[threadCount_];

        int tnum;
        for (tnum = 0; tnum < threadCount_; ++tnum) {
            threads[tnum] = new Thread(() -> {
                for (int d = 0; d < iterationCount_; ++d) {
                    c.increaseSuccessCount(d);
                    c.increaseSuccessCount(-d);
                }
            });
        }


        // Start all of the threads, and start timing
        long startTime = System.currentTimeMillis();
        for (Thread t: threads) {
            t.start();
        }


        // Wait for all the threads to terminate
        for (Thread t: threads) {
            try {
                t.join();
            }
            catch (InterruptedException ignore) {
                // Deliberately swallowed - nothing to do
            }
        }

        long endTime = System.currentTimeMillis();


        System.out.printf("Result was: %d and it completed in %f seconds%n",
                c.getSuccessCount(), (endTime - startTime) / 1000.0);
    }
}


