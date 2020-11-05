package com.company;

public final class StatsCounter {

    private int successCount_;
    
    private boolean isIncreaseCount = false;
    
    public final int getSuccessCount() {
        return successCount_;
    }
    public final synchronized void increaseSuccessCount(int delta) {
//       
        while (isIncreaseCount) {
       
       try {
            System.out.println("Waiting - inserting" + delta);
            wait();
       } catch (InterruptedException e) {
          e.printStackTrace();
        }
        }
        //successCount_ += delta;

        boolean isIncreasingCount = true;
        successCount_ += delta;
        isIncreasingCount = false;
        

       notifyAll();
       System.out.println( "Done insertion");
    }
}


