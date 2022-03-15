package sk.uniza.fri.game;

import sk.uniza.fri.enemy.ICreature;
import sk.uniza.fri.maps.Room;
import sk.uniza.fri.player.Player;
import java.util.ArrayList;

/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */
public class BattleManager {

    public boolean startFight(Player player, Room room) {
        ArrayList<ICreature> enemiesInRoom = room.getEnemiesInRoom();

        // ziadny nepriatelia v miestnosti
        if (enemiesInRoom == null) {
            return player.isDead();
        }
        System.out.println(" [" + enemiesInRoom.size() + " nepriatelov v miestnosti]");
        int round = 0;
        while (!enemiesInRoom.isEmpty()) {
            round += 1;
            for (ICreature creature : enemiesInRoom) {
                if (creature.isDead()) {
                    continue;
                }
                if (player.isDead()) {
                    System.out.println("-----------------------");
                    System.out.println("You died.");
                    System.out.println("-----------------------");
                    return true;
                }
                player.doDamage(creature);
                creature.doDamage(player);
            }
            this.printBattleSummaryAfterRound(enemiesInRoom, round, player);
            enemiesInRoom = this.removeDeadEnemies(enemiesInRoom);
        }
        return player.isDead();
    }

    private ArrayList<ICreature> removeDeadEnemies(ArrayList<ICreature> enemiesInRoom) {
        ArrayList<ICreature> enemiesAlive = new ArrayList<ICreature>();
        for (ICreature creature : enemiesInRoom) {
            if (!creature.isDead()) {
                enemiesAlive.add(creature);
            }
        }
        return enemiesAlive;
    }

    private void printBattleSummaryAfterRound(ArrayList<ICreature> enemies, int round, Player player) {
        System.out.println("Round " + round + ": ");
        System.out.println(String.format("[Player] %.2f HP", player.getHealth()));
        int index = 0;
        for (ICreature enemy : enemies) {
            if (!enemy.isDead()) {
                String formatted = String.format("[Enemy %d] has %.2f HP, ", index, enemy.getHealth());
                System.out.print(formatted);
            } else {
                System.out.print("[Enemy " + index + "] is dead, ");
            }
            index += 1;
        }
        System.out.println();
        System.out.println("--------------------------------");
    }
}
