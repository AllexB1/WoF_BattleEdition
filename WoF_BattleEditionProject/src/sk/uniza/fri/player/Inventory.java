package sk.uniza.fri.player;

import sk.uniza.fri.items.IItem;
import sk.uniza.fri.items.IUsable;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<IItem> inventoryUsable;
    private ArrayList<IItem> inventoryConsumable;

    public Inventory() {
        inventoryConsumable = new ArrayList<IItem>();
        inventoryUsable = new ArrayList<IItem>();
    }

    public void addItem(IItem item) {
        if (item == null) {
            return;
        }

        if (item instanceof IUsable) {
            inventoryUsable.add(item);
        } else {
            inventoryConsumable.add(item);
        }
    }









}
