package com.akosha.battle.service;

import com.akosha.battle.model.Warriors;

public interface BattlePreparationService {

    void producesSoldiers(int archerCount);
    void produceEmemies(int enemyCount);
    void startPreparation(int archerCount,int enemyCount);
    Warriors getWarriors();
}
