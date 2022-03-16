package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public class BananOfDamage implements IItem, IUsable {

    private static final float DAMAGE_MODIFIER = 5;
    private boolean wasUsed = false;
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
        if (!wasUsed) {
            player.addDamageModifier(this.DAMAGE_MODIFIER);
            System.out.println("Used banana of damage");
            this.wasUsed = true;
        }
    }
}








