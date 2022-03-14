package sk.uniza.fri.enemy;

/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */
public class Skeleton implements ICreature {

    private float health;
    private float damage;
    private float armor;

    public Skeleton(float health, float damage, float armor) {
        this.health = health;
        this.damage = damage;
        this.armor = armor;
    }

    // TODO
    public void doDamage(ICreature creature) {
        creature.takeDamage(this.damage);
    }

    // Take damage from other creatures of effects
    public void takeDamage(float damage) {
        float totalDamage = damage - this.armor;

        if (totalDamage > 0) {
            this.health -= totalDamage;
            System.out.println("Skeleton took " + totalDamage + " from attack.");
        }
    }

    // check if player is dead
    public boolean isDead() {
        return this.health <= 0;
    }
}
