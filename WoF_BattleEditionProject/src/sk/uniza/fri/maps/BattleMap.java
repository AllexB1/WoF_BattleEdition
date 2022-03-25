package sk.uniza.fri.maps;

import sk.uniza.fri.game.Game;

/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */
public class BattleMap {
    
    
    public Room createMap(Game game) {
        Room camp = new Room("Camp - vstup na bojove pole");
        Room kitchen = new Room("Kuchyna");
        Room mainHall = new Room("Hlavna hala");
        Room darkRoom = new Room("Temna miestnost");
        Room bossRoom = new Room("Vstupil si do temnej miestnosti. Vidies len svetlo z polozahasenzych fakiel, ktore osvetluju zeleneho orka v ciernom brneni.");
        TrappedRoom trap = new TrappedRoom("a pucujes cvaknutie, smrst sipov vyleti tvojim smerom........");
        // inicializacia Roomi = nastavenie vychodov
        camp.setExits(kitchen, mainHall, darkRoom);
        kitchen.setExits(null, trap, bossRoom);
        trap.setExits(bossRoom, null, null);
        mainHall.setExits(kitchen, bossRoom, darkRoom);
        darkRoom.setExits(bossRoom, null, null);
        bossRoom.setExits(null, null, null);

        // Nastavenie nepriatelov v miestnostiach
        kitchen.putEnemiesIntoRoom();
        darkRoom.putEnemiesIntoRoom();
        bossRoom.putEnemiesIntoRoom();
        return camp;  // startovacia Room hry
    }
}
