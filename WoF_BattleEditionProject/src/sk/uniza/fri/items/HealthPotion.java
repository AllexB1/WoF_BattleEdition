package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */
public class HealthPotion implements IItem, IConsumable {

    private static final float HEALTH = 10;
    private String name = "Health potion";

    @Override
    public void consume(Player player) {
        player.heal(this.HEALTH);
        player.getInventory().removeItem(this);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return String.format("After consuming, player heals for %.1f!", this.HEALTH);
    }
}
