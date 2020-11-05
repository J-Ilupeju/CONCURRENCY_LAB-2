package com.company;

public final class StatsCounter {

    private int successCount_;
    public final int getSuccessCount() {
        return successCount_;
    }
    public final void increaseSuccessCount(int delta) {
        successCount_ += delta;
    }
}


