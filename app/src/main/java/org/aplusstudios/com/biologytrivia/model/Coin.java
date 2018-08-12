package org.aplusstudios.com.biologytrivia.model;

public class Coin {

    private int numberOfCoinsEarned;
    private int spentCoins;
    private int coinsBalance;

    public Coin(int numberOfCoinsEarned, int spentCoins, int coinsBalance) {
        this.numberOfCoinsEarned = numberOfCoinsEarned;
        this.spentCoins = spentCoins;
        this.coinsBalance = coinsBalance;
    }

    public int getNumberOfCoinsEarned() {
        return numberOfCoinsEarned;
    }

    public void setNumberOfCoinsEarned(int numberOfCoinsEarned) {
        this.numberOfCoinsEarned = numberOfCoinsEarned;
    }

    public int getSpentCoins() {
        return spentCoins;
    }

    public void setSpentCoins(int spentCoins) {
        this.spentCoins = spentCoins;
    }

    public int getCoinsBalance() {
        return coinsBalance;
    }

    public void setCoinsBalance(int coinsBalance) {
        this.coinsBalance = coinsBalance;
    }
}
