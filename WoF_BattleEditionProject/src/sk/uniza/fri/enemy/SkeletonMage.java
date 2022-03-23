package sk.uniza.fri.enemy;

import java.util.Random;

/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */
public class SkeletonMage extends Skeleton {

    private static final float MIN_HP = 10;
    private static final float MAX_HP = 20;
    private final String name = "Skeleton Mage";
    private float health;

    private int roundCounter = 0;

    public SkeletonMage() {
        Random random = new Random();
        this.health = random.nextFloat(MIN_HP, MAX_HP);
    }

    public void doDamage(ICreature creature) {
        if (roundCounter > 2) {
            creature.takeDamage(40);
            roundCounter = 0;
        } else {
            roundCounter += 1;
        }
    }
}
