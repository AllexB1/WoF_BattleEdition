package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public class BananOfDamage implements IItem, IUsable {

    private static final float DAMAGE_MODIFIER = 5;
    @Override
    public String getName() {
        return "Banan of Damage";
    }

    @Override
    public String getDescription() {
        return String.format("For next fight player has %.1f damage!", this.DAMAGE_MODIFIER);
    }

    @Override
    public void use(Player player) {
        player.addDamageModifier();
    }
}
