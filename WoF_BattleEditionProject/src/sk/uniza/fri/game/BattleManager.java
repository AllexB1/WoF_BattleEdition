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
    // Battle simulation
    // get enemies from room (if there are any)
    // loop until all enemies are dead or until player is dead
    // each round player attacks every enemy
    // each enemy attacks player once per turn
    public boolean startFight(Player player, Room room) {
        ArrayList<ICreature> enemiesInRoom = room.getEnemiesInRoom();

        // ziadny nepriatelia v miestnosti
        if (enemiesInRoom == null) {
            return player.isDead();
        }
        System.out.println(" [" + enemiesInRoom.size() + " nepriatelov v miestnosti]");
        // start of the fight
        int round = 0;
        this.printBattleSummaryAfterRound(enemiesInRoom, round, player);
        while (!enemiesInRoom.isEmpty()) {
            // start of the round
            round += 1;
            player.useItems();
            // during round
            for (ICreature creature : enemiesInRoom) {
                if (player.isDead()) {
                    System.out.println("-----------------------");
                    System.out.println("You died.");
                    System.out.println("-----------------------");
                    return true;
                }
                // fight between player and creature
                player.doDamage(creature);
                if (creature.isDead()) {
                    continue;
                }
                creature.doDamage(player);
            }
            // end of the round
            this.printBattleSummaryAfterRound(enemiesInRoom, round, player);
            enemiesInRoom = this.removeDeadEnemies(enemiesInRoom);
        }
        // end of fight
        player.resetModifiers();
        return player.isDead();
    }

    // find dead enemies
    // copy them to new list
    // modify the old list and return only living creatures
    private ArrayList<ICreature> removeDeadEnemies(ArrayList<ICreature> enemiesInRoom) {
        ArrayList<ICreature> enemiesAlive = new ArrayList<ICreature>();
        for (ICreature creature : enemiesInRoom) {
            if (!creature.isDead()) {
                enemiesAlive.add(creature);
            }
        }
        return enemiesAlive;
    }

    // print basic statistics after each round
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
