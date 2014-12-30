package com.akosha.battle.model;

import java.util.ArrayList;

public class Warriors {

    private ArrayList<Archer> archers = new ArrayList<Archer>();
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    public ArrayList<Archer> getArchers() {
        return archers;
    }

    public void setArchers(ArrayList<Archer> archers) {
        this.archers = archers;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }
    
    public void resetWarriors(){
        archers.clear();
        enemies.clear();
    }

}
