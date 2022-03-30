package sk.uniza.fri.maps;

import sk.uniza.fri.player.Player;

import java.util.Scanner;

public class TrapRoom extends Room {
    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne
     * charakterizuje.
     *
     * @param popis text popisu miestnosti.
     */
    public TrapRoom(String popis) {
        super(popis);
        System.out.println("Nastavila sa pasca");
    }


    public void triggerTrap(Player player) {
        System.out.println("Opis tento string: 'asd'");
        Scanner sc = new Scanner(System.in);

        if (sc.next().equals("asd")) {
            System.out.println("Uspesne si presiel pascu");
        } else {
            player.takeDamage(999);
        }
    }



}
