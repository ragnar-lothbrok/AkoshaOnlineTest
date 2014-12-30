package com.akosha.battle.service;

import java.util.ArrayList;

import com.akosha.battle.model.Archer;
import com.akosha.battle.model.Arrow;
import com.akosha.battle.model.SpecialArrow;
import com.akosha.battle.model.Warriors;
import com.akosha.battle.model.Enemy;

public class BattlePreparationServiceImpl implements BattlePreparationService {

    private Warriors warriors = new Warriors();
    private int countOfArrows = 1;
    private int countOfArchers = 1;
    
    public void producesSoldiers(int archerCount) {
        warriors.getArchers().clear();
        for (int i = 1; i <= archerCount; i++) {
            Archer archer = new Archer();
            ArrayList<Arrow> arrowsList = getArrows();
            archer.setArrows(arrowsList);
            warriors.getArchers().add(archer);
        }
    }

    public void produceEmemies(int enemyCount) {
        warriors.getEnemies().clear();
        for (int i = 1; i <= enemyCount; i++) {
            Enemy enemy = new Enemy();
            enemy.setStrength(i * 2);
            warriors.getEnemies().add(enemy);
        }
    }

    public ArrayList<Arrow> getArrows() {
        ArrayList<Arrow> list = new ArrayList<Arrow>();
        for (int i = 0; i < countOfArchers; i++) {
            if (countOfArrows == 5) {
                list.add(new SpecialArrow());
                countOfArrows = 1;
            } else {
                countOfArrows += 1;
                list.add(new Arrow());
            }
        }
        countOfArchers++;
        return list;
    }

    @Override
    public Warriors getWarriors() {
        return warriors;
    }

    @Override
    public void startPreparation(int archerCount, int enemyCount) {
        warriors.resetWarriors();
        producesSoldiers(archerCount);
        produceEmemies(enemyCount);
    }

}
