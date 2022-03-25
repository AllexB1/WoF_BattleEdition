package sk.uniza.fri.maps;

import sk.uniza.fri.player.Player;

import java.util.Scanner;

/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */
public class TrappedRoom extends Room {

    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne
     * charakterizuje.
     *
     * @param popis text popisu miestnosti.
     */
    public TrappedRoom(String popis) {
        super(popis);
    }

    public void triggerTrap(Player player) {
        System.out.println("Trap was triggered");
        System.out.println("Opis tento string do terminalu aby si sa uhol 'asdfjahsdfjahsjkdfhaksjd'");
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        if (input.equals("asdfjahsdfjahsjkdfhaksjd")) {
            System.out.println("Uhol si sa utoku");
        } else {
            System.out.println("Ouch dostal si " + 30 + " damagu!");
            player.takeDamage(30);
        }
    }


}
