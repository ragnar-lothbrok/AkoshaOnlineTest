import java.util.Scanner;

import com.akosha.battle.service.BattleService;
import com.akosha.battle.service.BattleServiceImpl;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of Archers: ");
        int archerCount = in.nextInt();
        while(archerCount < 0){
            System.out.println("Please Enter valid number of Archers: ");
            archerCount = in.nextInt();
        }
        System.out.println("Enter number of Enemies: ");
        int enemyCount = in.nextInt();
        while(enemyCount < 0){
            System.out.println("Please Enter valid number of Enemies: ");
            enemyCount = in.nextInt();
        }
        
        BattleService battleService = new BattleServiceImpl();
        battleService.startBattle(archerCount, enemyCount);
    }
}
