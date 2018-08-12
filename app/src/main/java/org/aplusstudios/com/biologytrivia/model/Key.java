package org.aplusstudios.com.biologytrivia.model;

public class Key {

    private int numberOfKeysEarned;
    private int usedKeys;
    private int keysBalance;

    public Key(int numberOfKeysEarned, int usedKeys, int keysBalance) {
        this.numberOfKeysEarned = numberOfKeysEarned;
        this.usedKeys = usedKeys;
        this.keysBalance = keysBalance;
    }

    public int getNumberOfKeysEarned() {
        return numberOfKeysEarned;
    }

    public void setNumberOfKeysEarned(int numberOfKeysEarned) {
        this.numberOfKeysEarned = numberOfKeysEarned;
    }

    public int getUsedKeys() {
        return usedKeys;
    }

    public void setUsedKeys(int usedKeys) {
        this.usedKeys = usedKeys;
    }

    public int getKeysBalance() {
        return keysBalance;
    }

    public void setKeysBalance(int keysBalance) {
        this.keysBalance = keysBalance;
    }
}
