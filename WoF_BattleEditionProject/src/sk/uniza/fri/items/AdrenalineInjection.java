package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */
public class AdrenalineInjection implements IItem, IUsable {

    private static final String NAME = "Adrenaline Injection";
    private static final float DAMAGE_MODIFIER = 5;
    private boolean usedThisFight = false;

    @Override
    public String getName() {
        return this.NAME;
    }

    @Override
    public String getDescription() {
        return String.format("For next fight player has + %d damage!", this.DAMAGE_MODIFIER);
    }

    @Override
    public void use(Player player) {
        if (!this.usedThisFight) {
            player.setDamageModifier(this.DAMAGE_MODIFIER);
            System.out.println("Using adrenaline injection " + player.getDamageModifier());
            usedThisFight = true;
        }
    }
}
