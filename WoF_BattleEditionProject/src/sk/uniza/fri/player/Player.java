package sk.uniza.fri.player;

import sk.uniza.fri.enemy.ICreature;
import sk.uniza.fri.items.BananOfDamage;
import sk.uniza.fri.items.IItem;
import sk.uniza.fri.items.IUsable;


/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */
public class Player implements ICreature {

    private float health;
    private float damage;
    private float armor;

    // Inventory
    //private ArrayList<IItem> inventory = new ArrayList<>();
    private Inventory inventory = new Inventory();

    //modifier
    private float damageModifier;

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
        creature.takeDamage(this.damage + this.damageModifier);
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

    // Modifiers for damage, health and armor
    public void addDamageModifier(float damageModifier) {
        this.damageModifier = damageModifier;
    }

    public void useItems() {
        // TODO
        for (IItem item: this.inventory.getUsableItems()) {
            if (item instanceof IUsable) {
                ((IUsable)item).use(this);
            }
        }
    }

    public void addItemToInventory(BananOfDamage bananOfDamage) {
        if (bananOfDamage != null) {
            this.inventory.addItem(bananOfDamage);
        }
    }

    public void heal(float healthAdd) {
        this.health += healthAdd;
    }

    public Inventory getInventory() {
        return this.inventory;
    }
}











