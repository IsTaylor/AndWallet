package com.example.owner.andwallet;

/**
 * Created by owner on 10/20/17.
 */

public class SummaryData {

    private static SummaryData summaryData = null;

    public static SummaryData getInstance() {
        if (summaryData == null) {
            summaryData = new SummaryData();
        }

        return summaryData;
    }

    private int income = 0;
    private int outcome = 0;
    private int total = 0;

    public void addIncome(int toAdd) {
        this.income += toAdd;
        total += toAdd;
    }

    public void addOutcome(int toAdd) {
        this.outcome += toAdd;
        total -= toAdd;
    }

    public int getIncome() {
        return income;
    }

    public int getOutcome() {
        return outcome;
    }

    public int getTotal() {
        return total;
    }

    public void reset() {
        outcome = 0;
        income = 0;
        total = 0;
    }
}
