package sk.uniza.fri.maps;

import sk.uniza.fri.items.AppleOfHealth;
import sk.uniza.fri.items.BananOfDamage;
import sk.uniza.fri.items.HealthPotion;
import sk.uniza.fri.items.IItem;
import sk.uniza.fri.player.Player;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class ShopRoom extends Room {

    private HashMap<IItem, Float> tradeGoods;

    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne
     * charakterizuje.
     *
     * @param popis text popisu miestnosti.
     */
    public ShopRoom(String popis) {
        super(popis);
        this.tradeGoods = new HashMap<IItem, Float>();
        this.tradeGoods.put(new BananOfDamage(), 20f);
        this.tradeGoods.put(new AppleOfHealth(), 10f);
        this.tradeGoods.put(new HealthPotion(), 15f);
        System.out.println("Nastavil sa obchod");
    }

    public void openShop(Player player) {
        System.out.println("Otvoril si dvere a vidis obchod");

        for (IItem item : this.tradeGoods.keySet()) {
            String info = String.format("[%s] %.1f", item.getName(), this.tradeGoods.get(item));
            System.out.println(info);
        }

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        player.getInventory().addItem(new BananOfDamage());
        player.takeDamage(this.tradeGoods.get(new BananOfDamage()));
    }
}








