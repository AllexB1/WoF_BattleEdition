package sk.uniza.fri.enemy;

import java.util.Random;

/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */
public class Skeleton implements ICreature {

    private static final float MIN_HP = 10;
    private static final float MAX_HP = 40;
    private final String name = "Skeleton";
    protected float health;
    private float damage;
    private float armor;

    public Skeleton() {
        Random random = new Random();
        this.health = random.nextFloat(MIN_HP, MAX_HP);
        this.damage = ICreature.BASE_DAMAGE;
        this.armor = ICreature.BASE_ARMOR;
    }

    public float getHealth() {
        return this.health;
    }

    @Override
    public void heal(float healAmount) {
        this.health += healAmount;
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
           // System.out.print(this.name + " took " + totalDamage + " from attack. ");
        }
    }

    // check if player is dead
    public boolean isDead() {
        return this.health <= 0;
    }

    public String getName() {
        return name;
    }
}
