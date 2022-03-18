package sk.uniza.fri.player;

import sk.uniza.fri.items.IItem;
import sk.uniza.fri.items.IUsable;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<IItem> inventoryUsable;
    private ArrayList<IItem> inventoryConsumable;

    public Inventory() {
        this.inventoryConsumable = new ArrayList<IItem>();
        this.inventoryUsable = new ArrayList<IItem>();
    }

    public void addItem(IItem item) {
        if (item == null) {
            return;
        }

        if (item instanceof IUsable) {
            this.inventoryUsable.add(item);
        } else {
            this.inventoryConsumable.add(item);
        }
    }

    public void removeItem(IItem item) {
        if (item == null) {
            return;
        }

        if (this.inventoryUsable.contains(item)) {
            this.inventoryUsable.remove(item);
            return;
        }

        if (this.inventoryConsumable.contains(item)) {
            this.inventoryConsumable.remove(item);
        }
    }

    public void showItems() {
        System.out.println("Usable items");
        for (IItem item : this.inventoryUsable) {
            String itemText = String.format("[%s] : %s", item.getName(), item.getDescription());
            System.out.println(itemText);
        }
        System.out.println("Consumables");
        for (IItem item : this.inventoryConsumable) {
            String itemText = String.format("[%s] : %s", item.getName(), item.getDescription());
            System.out.println(itemText);
        }
    }

    public IItem[] getUsableItems() {
        return (IItem[])this.inventoryUsable.toArray();
    }
}
















