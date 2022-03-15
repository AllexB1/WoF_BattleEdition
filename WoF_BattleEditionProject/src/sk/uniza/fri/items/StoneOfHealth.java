package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */
public class StoneOfHealth implements IItem, IUsable {

    private static final String NAME = "Stone of Health";
    private static final float HEALING_AMOUNT = 1;

    @Override
    public String getName() {
        return this.NAME;
    }

    @Override
    public String getDescription() {
        return String.format("Add %.0f health each round", this.HEALING_AMOUNT);
    }

    @Override
    public void use(Player player) {
        System.out.print("Before heal " + player.getHealth() + " ");
        player.heal(this.HEALING_AMOUNT);
        System.out.println("After " + player.getHealth());
    }
}
