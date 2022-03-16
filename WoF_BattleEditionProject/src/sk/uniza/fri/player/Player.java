package sk.uniza.fri.player;

import sk.uniza.fri.enemy.ICreature;
import sk.uniza.fri.items.IItem;
import sk.uniza.fri.items.IUsable;
import sk.uniza.fri.userInteraction.Command;

import java.util.ArrayList;

/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */
public class Player implements ICreature {

    private float health;
    private float damage;
    private float armor;

    private ArrayList<IItem> inventory;
    // modifiers
    private float damageModifier = 0;

    public Player(float health, float damage, float armor) {
        this.health = health;
        this.damage = damage;
        this.armor = armor;
        // create empty inventory
        inventory = new ArrayList<IItem>();
    }

    @Override
    public float getHealth() {
        return this.health;
    }

    // could be set
    // but we want to control amount which will be healed
    // heal method could be modified in the future
    public void heal(float amount) {
        if (amount > 0) {
            this.health = this.health + amount;
        }
    }

    public void useItems() {
        for (IItem item : inventory) {
            if (item instanceof IUsable) {
                ((IUsable)item).use(this);
            }
        }
    }

    public void doDamage(ICreature creature) {
        // TODO
        // calculate damage
        float dmg =  this.damage + this.getDamageModifier();
        creature.takeDamage(this.damage + this.getDamageModifier());
    }

    // Take damage from other creatures of effects
    public void takeDamage(float damage) {
        float totalDamage = damage - this.armor;

        if (totalDamage > 0) {
            this.health -= totalDamage;
            //System.out.println("Player took " + totalDamage + " from attack.");
        }
    }

    // clean up after fight
    public void resetModifiers() {
        this.setDamageModifier(0);
        // TODO additional modifiers
    }

    // Print info about current stats
    public void printInfo() {
        System.out.println("-----------------------");
        System.out.println("Player current stats: ");
        System.out.print("Health: " + this.health);
        System.out.print(" Damage: " + this.damage);
        System.out.print(" Armor: " + this.armor);
        System.out.println();
        System.out.println("-----------------------");
    }

    // Inventory
    // Add item to inventory
    // any checks related to size of inventory or compatibility of items
    // should be made here
    public void addItemToInventory(IItem item) {
        this.inventory.add(item);
    }

    // check if item is in inventory
    // remove item
    public void removeItemFromInventory(IItem item) {
        if (this.inventory.contains(item)) {
            this.inventory.remove(item);
        }
    }

    // prints items with description to console
    public void show(Command command) {
        if (!command.hasParameter()) {
            return;
        }

        if (command.getParameter().equals("inventory")) {
            System.out.println("Items in inventory:");
            for (IItem item : inventory) {
                System.out.println(item.getName() + ": " + item.getDescription());
            }
        } else {
            boolean foundItem = false;
            for (IItem item : inventory) {
                String itemNameWithoutWhiteSpace = item.getName().replaceAll(" ", "").toLowerCase();
                if (itemNameWithoutWhiteSpace.equals(command.getParameter().toLowerCase())) {
                    System.out.println(String.format("Item [%s] : %s", item.getName(), item.getDescription()));
                    foundItem = true;
                    break;
                }
            }
            if (!foundItem) {
                System.out.println("No item with name [" + command.getParameter() + "] in inventory");
            }
        }
    }

    // check if player is dead
    public boolean isDead() {
        return this.health <= 0;
    }

    // Getters and Setters
    public float getDamageModifier() {
        return damageModifier;
    }

    // Set modifiers (HP, damage, armor, etc...)
    // modifiers are used to modify base values of health, damage, armor without
    // changing it's value
    // set damage modifier
    public void setDamageModifier(float damageModifier) {
        this.damageModifier = damageModifier;
    }
}
