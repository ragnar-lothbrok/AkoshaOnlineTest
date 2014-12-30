package com.akosha.battle.model;

public class Enemy {
    private int strength;

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public boolean hasMoreStrength() {
        return getStrength() > 0;
    }

    public void reduceStrengthBy(int a) {
        strength -= a;
    }

    public void increaseStrengthBy(int a) {
        strength += a;
    }
}
