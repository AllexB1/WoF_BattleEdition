package sk.uniza.fri.player;

import sk.uniza.fri.enemy.ICreature;

/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */
public class Player implements ICreature {

    private float health;
    private float damage;
    private float armor;

    public Player(float health, float damage, float armor) {
        this.health = health;
        this.damage = damage;
        this.armor = armor;
    }

    @Override
    public float getHealth() {
        return this.health;
    }

    public void doDamage(ICreature creature) {
        // TODO
        // calculate damage
        creature.takeDamage(this.damage);
    }

    // Take damage from other creatures of effects
    public void takeDamage(float damage) {
        float totalDamage = damage - this.armor;

        if (totalDamage > 0) {
            this.health -= totalDamage;
            //System.out.println("Player took " + totalDamage + " from attack.");
        }
    }

    public void printInfo() {
        System.out.println("-----------------------");
        System.out.println("Player current stats: ");
        System.out.print("Health: " + this.health);
        System.out.print(" Damage: " + this.damage);
        System.out.print(" Armor: " + this.armor);
        System.out.println();
        System.out.println("-----------------------");
    }

    // check if player is dead
    public boolean isDead() {
        return this.health <= 0;
    }


}
