package sk.uniza.fri.game;

import sk.uniza.fri.items.BananOfDamage;
import sk.uniza.fri.items.HealthPotion;
import sk.uniza.fri.items.StrawberryOfArmor;
import sk.uniza.fri.maps.BattleMap;
import sk.uniza.fri.maps.Room;
import sk.uniza.fri.maps.TrappedRoom;
import sk.uniza.fri.player.Player;
import sk.uniza.fri.userInteraction.Command;
import sk.uniza.fri.userInteraction.Parser;

/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */
public class Game {
    private final Parser parser;
    private final BattleMap battleMap;
    private final BattleManager battleManager;
    private Room currentRoom;
    private Player player;

    public Game() {
        this.battleMap = new BattleMap();
        this.currentRoom = this.battleMap.createMap(this);
        this.parser = new Parser();
        this.battleManager = new BattleManager();
        this.player = new Player(100, 10, 8);
       /* this.player.addItemToInventory(new BananOfDamage());
        this.player.addItemToInventory(new StrawberryOfArmor());
        this.player.addItemToInventory(new HealthPotion());*/
    }

    public void play() {
        this.printInvitation();

        boolean isEnd = false;

        do {
            Command command = this.parser.getCommandFromInput();
            isEnd = this.performCommand(command);
            // Start battle if there are enemies in room
            if (!command.isUnknown() && command.getName().equals("go")) {
                if(isEnd) {
                    break;
                }
                if (this.currentRoom.getEnemiesInRoom() != null) {
                    isEnd = this.battleManager.startFight(this.player, this.currentRoom);
                } else if (this.currentRoom instanceof TrappedRoom) {
                    ((TrappedRoom)this.currentRoom).triggerTrap(this.player);
                }
            }
            if (!isEnd) {
                this.player.printInfo();
                if (!this.isLastRoom(this.currentRoom)) {
                    this.printRooms();
                } else {
                    System.out.println("YOU WON!");
                    isEnd = true;
                }
            }
        } while (!isEnd);
        if (this.player.isDead()) {
            System.out.println("YOU DIED!");
        }
    }

    // TODO rework. This is not optimal
    private boolean isLastRoom(Room currentRoom) {
        if (currentRoom.getLeftExit() == null) {
            if (currentRoom.getMiddleExit() == null) {
                if (currentRoom.getRightExit() == null) {
                    // no more exits, we are at the end
                    return true;
                }
            }
        }
        // still has exits
        return false;
    }


    // spracovanie prikazov
    private boolean performCommand(Command command) {
        if (command.isUnknown()) {
            System.out.println("Nerozumiem, co mas na mysli...");
            return false;
        }

        String commandName = command.getName();

        switch (commandName) {
            case "help":
                this.printHelp();
                return false;
            case "go":
                this.moveToRoom(command);
                return false;
            case "end":
                return this.endGame(command);
            case "show":
                this.show(command);
                return false;
            default:
                return false;
        }
    }

    private void show(Command command) {

        // check obejct to show
        switch (command.getParameter()) {
            case "inventory":
                // get inventory from player
                    // show items
                this.player.getInventory().showItems();

        }

    }

    // ukoncenie hry
    // prikaz nema ziadny parameter
    // ak je prikaz naozaj ukonci  vratime false a ukoncime cyklus
    private boolean endGame(Command command) {
        if (command.hasParameter()) {
            System.out.println("Ukonci, co?");
            return false;
        } else {
            return true;
        }
    }

    private void moveToRoom(Command command) {
        if (!command.hasParameter()) {
            // ak prikaz nema parameter - druhe slovo - nevedno kam ist
            System.out.println("Chod kam?");
            return;
        }

        String direction = command.getParameter();

        // Pokus o opustenie aktualnej miestnosti danym vychodom.
        Room newRoom = null;

        switch (direction) {
            case "left":
                newRoom = this.currentRoom.getLeftExit();
                break;
            case "middle":
                newRoom = this.currentRoom.getRightExit();
                break;
            case "right":
                newRoom = this.currentRoom.getMiddleExit();
                break;
        }

        if (newRoom == null) {
            System.out.println("Tam nie je vychod!");
        } else {
            this.currentRoom = newRoom;
            this.printRooms();
        }
    }

    // Vypis info o miestnosti a o hre
    private void printRooms() {
        System.out.println("Teraz si v miestnosti " + this.currentRoom.getDescription());
        System.out.print("Vychody: ");
        if (this.currentRoom.getLeftExit() != null) {
            System.out.print("left ");
        }
        if (this.currentRoom.getRightExit() != null) {
            System.out.print("middle ");
        }
        if (this.currentRoom.getMiddleExit() != null) {
            System.out.print("right ");
        }
        System.out.println();
    }

    private void printInvitation() {
        System.out.println();
        System.out.println("Vitaj v hre World of FRI!");
        System.out.println("World of FRI - Battle Edition je bojova verzia byvalej adventuri.");
        System.out.println("Cielom hry je prebojovat sa na koniec pevnosti a porazit bossa.");
        System.out.println("Zadaj 'help' ak potrebujes pomoc.");
        System.out.println("Prikazy: 'go' 'help' 'end'");
        System.out.println();
        this.printRooms();
    }

    private void printHelp() {
        System.out.println("Mozes pouzit tieto prikazy:");
        System.out.println("   chod ukonci pomoc");
    }


}
