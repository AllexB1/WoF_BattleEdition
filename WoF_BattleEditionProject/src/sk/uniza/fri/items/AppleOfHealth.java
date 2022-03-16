package sk.uniza.fri.items;

import sk.uniza.fri.player.Player;

public class AppleOfHealth implements IItem, IUsable {
    private static final float HEALTH_ADD = 1;
    @Override
    public String getName() {
        return "Apple of health";
    }

    @Override
    public String getDescription() {
        return "Each round add 1 HP";
    }

    @Override
    public void use(Player player) {
        player.heal(this.HEALTH_ADD);
    }
}
