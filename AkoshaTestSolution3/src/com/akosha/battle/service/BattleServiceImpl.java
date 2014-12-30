package com.akosha.battle.service;

import java.util.List;

import com.akosha.battle.model.Archer;
import com.akosha.battle.model.Arrow;
import com.akosha.battle.model.Enemy;
import com.akosha.battle.model.Warriors;

public class BattleServiceImpl implements BattleService {

    @Override
    public String[] startBattle(int archerCount, int enemyCount) {
        BattlePreparationService battlePreparationService = new BattlePreparationServiceImpl();
        battlePreparationService.startPreparation(archerCount, enemyCount);
        Warriors warriors = battlePreparationService.getWarriors();
        List<Archer> archers = warriors.getArchers();
        List<Enemy> enemies = warriors.getEnemies();
        
        String battleResult[] = new String[3];
        int enenyKilled = 0;
        int arrowsFired = 0;
        Archer archer = null;
        Enemy enemy = null;
        if(archers.size() > 0 && enemies.size() > 0){
            archer = archers.remove(0);
            enemy = enemies.remove(0);
            while ((archers.size() > 0 || (archer != null && archer.hasMoreArrows()))
                    && (enemies.size() > 0 || (enemy != null && enemy.hasMoreStrength()))) {
                if (archer == null || !archer.hasMoreArrows()) {
                    archer = archers.remove(0);
                }
                if (enemy == null || !enemy.hasMoreStrength()) {
                    enemy = enemies.remove(0);
                }
                while (archer.hasMoreArrows() || enemy.hasMoreStrength()) {
                    if (archer.getNumArrows() >= enemy.getStrength()) {
                        arrowsFired++;
                        Arrow arrow = archer.removeArrow();
                        if (arrowsFired % 7 == 0) {
                            enemy.increaseStrengthBy(2);
                        } else {
                            enemy.reduceStrengthBy(arrow.getStrength());
                        }
                    } else {
                        archer.removeAllArrows();
                        break;
                    }
                    if (!enemy.hasMoreStrength()) {
                        break;
                    }
                }
            }
        }

        if (enemies.size() > 0 || (enemy != null && enemy.hasMoreStrength())) {
            System.out.println("Battle - Lost");
            battleResult[0] = "Lost";
        } else if (archers.size() > 0 || (archer != null && archer.getNumArrows() >= 0)) {
            System.out.println("Battle - Won");
            battleResult[0] = "Won";
        }else{
            System.out.println("No Battle");
            battleResult[0] = "No Battle";
        }

        enenyKilled = ((enemyCount >=0 ? enemyCount : 0) - enemies.size() - ((enemy != null ?(enemy.hasMoreStrength() ? 1 : 0):0)));
        System.out.println("Total Enemies Killed: " + enenyKilled);
        System.out.println("Total Arrows Fired: " + arrowsFired);
        
        battleResult[1] = enenyKilled+"";
        battleResult[2] = arrowsFired+"";
        
        return battleResult;

    }

}
