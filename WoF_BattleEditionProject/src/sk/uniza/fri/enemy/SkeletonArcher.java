package sk.uniza.fri.enemy;

/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */
public class SkeletonArcher extends Skeleton {

    private final String name = "Skeleton Archer";
    private final float damage = 50;
    private int roundCounter = 0;

    public void doDamage(ICreature creature) {
        if (this.roundCounter > 2) {
            creature.takeDamage(this.damage);
            this.roundCounter = 0;
        } else {
            this.roundCounter += 1;
        }
    }

    public String getName() {
        return this.name;
    }
}
