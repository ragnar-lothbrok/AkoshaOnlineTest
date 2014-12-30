package com.akosha.battle.test;

import org.junit.Assert;
import org.junit.Test;

import com.akosha.battle.service.BattleService;
import com.akosha.battle.service.BattleServiceImpl;

public class BattleTest {
    
    BattleService battleService = new BattleServiceImpl();
    
    @Test
    public void test1() {
        String[] battleResult = battleService.startBattle(4, 2);
        Assert.assertEquals("Test for Battle Result" ,"Won",battleResult[0]);
    }
    
    @Test
    public void test2() {
        String[] battleResult = battleService.startBattle(20, 5);
        Assert.assertEquals("Test for Battle Result" ,"Won",battleResult[0]);
    }
    
    @Test
    public void test3() {
        String[] battleResult = battleService.startBattle(100, 50);
        Assert.assertEquals("Test for Battle Result" ,"Lost",battleResult[0]);
    }
    
    @Test
    public void test4() {
        String[] battleResult = battleService.startBattle(70, 40);
        Assert.assertEquals("Test for Battle Result" ,1428+"",battleResult[2]);
    }
    
    @Test
    public void test5() {
        String[] battleResult = battleService.startBattle(-1, 40);
        Assert.assertEquals("Test for Battle Result" ,"Lost",battleResult[0]);
    }
    
    @Test
    public void test6() {
        String[] battleResult = battleService.startBattle(1, 0);
        Assert.assertEquals("Test for Battle Result" ,"Won",battleResult[0]);
    }
    
    @Test
    public void test7() {
        String[] battleResult = battleService.startBattle(0, 1);
        Assert.assertEquals("Test for Battle Result" ,"Lost",battleResult[0]);
    }
    
    @Test
    public void test8() {
        String[] battleResult = battleService.startBattle(1, -1);
        Assert.assertEquals("Test for Battle Result" ,"Won",battleResult[0]);
    }
    
    @Test
    public void test9() {
        String[] battleResult = battleService.startBattle(-1, 1);
        Assert.assertEquals("Test for Battle Result" ,"Lost",battleResult[0]);
    }
    
    @Test
    public void test10() {
        String[] battleResult = battleService.startBattle(2, 1);
        Assert.assertEquals("Test for Battle Result" ,"Won",battleResult[0]);
    }
    
}
