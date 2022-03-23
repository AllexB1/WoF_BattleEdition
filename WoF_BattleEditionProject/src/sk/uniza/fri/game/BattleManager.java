package sk.uniza.fri.game;

import sk.uniza.fri.enemy.ICreature;
import sk.uniza.fri.items.*;
import sk.uniza.fri.maps.Room;
import sk.uniza.fri.player.Player;
import java.util.ArrayList;
import java.util.Random;

/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */
public class BattleManager {

    private ArrayList<IItem> rewards = new ArrayList<IItem>();

    public BattleManager() {
        this.rewards.add(new BananOfDamage());
        this.rewards.add(new AppleOfHealth());
        this.rewards.add(new StrawberryOfArmor());
        this.rewards.add(new HealthPotion());
    }

    public boolean startFight(Player player, Room room) {
        ArrayList<ICreature> enemiesInRoom = room.getEnemiesInRoom();

        // ziadny nepriatelia v miestnosti
        if (enemiesInRoom == null) {
            return player.isDead();
        }
        System.out.println(" [" + enemiesInRoom.size() + " nepriatelov v miestnosti]");
        int round = 0;
        while (!enemiesInRoom.isEmpty()) {
            // start of round
            round += 1;
            player.useItems();
            // during round
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
            // end of round
            this.printBattleSummaryAfterRound(enemiesInRoom, round, player);
            enemiesInRoom = this.removeDeadEnemies(enemiesInRoom);
        }
        // end of fight
        player.resetModifiers();
        player.addItemToInventory(this.getRandomReward());
        return player.isDead();
    }

    // vrat nahodny predmet
    private IItem getRandomReward() {
        Random rand = new Random();
        return this.rewards.get(rand.nextInt(0, this.rewards.size()));
    }

    // odstran mrtvych nepriatelov
    private ArrayList<ICreature> removeDeadEnemies(ArrayList<ICreature> enemiesInRoom) {
        ArrayList<ICreature> enemiesAlive = new ArrayList<ICreature>();
        for (ICreature creature : enemiesInRoom) {
            if (!creature.isDead()) {
                enemiesAlive.add(creature);
            }
        }
        return enemiesAlive;
    }


    // Vypis info po boji
    private void printBattleSummaryAfterRound(ArrayList<ICreature> enemies, int round, Player player) {
        System.out.println("Round " + round + ": ");
        System.out.println(String.format("[%s] %.2f HP", player.getName(), player.getHealth()));
        int index = 0;
        for (ICreature enemy : enemies) {
            if (!enemy.isDead()) {
                String formatted = String.format("[%s %d] has %.2f HP, ", enemy.getName() , index, enemy.getHealth());
                System.out.print(formatted);
            } else {
                System.out.print("[" + enemy.getName() + " " + index + "] is dead, ");
            }
            index += 1;
        }
        System.out.println();
        System.out.println("--------------------------------");
    }
}
