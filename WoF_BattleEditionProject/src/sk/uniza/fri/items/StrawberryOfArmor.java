package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */
public class StrawberryOfArmor implements IItem, IUsable {

    private static final float ARMOR_MODIFIER = 1;
    private boolean wasUsed = false;
    @Override
    public String getName() {
        return "Strawberry of Armor";
    }

    @Override
    public String getDescription() {
        return String.format("For next fight player has +%.1f armor!", this.ARMOR_MODIFIER);
    }

    @Override
    public void use(Player player) {
        if (!this.wasUsed) {
            player.addArmorModifier(this.ARMOR_MODIFIER);
            System.out.println("Used " + this.getName());
            this.wasUsed = true;
        }
    }
}
