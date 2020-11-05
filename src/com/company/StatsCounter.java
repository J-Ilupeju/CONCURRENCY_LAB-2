package com.company;

public final class StatsCounter {

    private int successCount_;
    public final int getSuccessCount() {
        return successCount_;
    }
    public final synchronized void increaseSuccessCount(int delta) {
//        try {
//            wait();
//        } catch (InterruptedException e) {
//           // e.printStackTrace();
//        }
        successCount_ += delta;

//        notifyAll();
//        System.out.println( "Done insertion");
    }
}


