# WoF_BattleEdition
 World of Fri - Battle edition is a game, where you have to fight through dark rooms of building to reach end boss restraining you from leaving alive. 

 ***Hint: Game is in "main" branch, donwload zip or clone repository in top right corner***
 ## Ideas
 Some ideas which we will add as we develop our game.
 ### NPC
 - Merchants
   - items
   - buffs
   - negative effets
 - Buffs
   - temporary
   - permanent
 - ??
 ### Rooms
- with enemies
- empty
- with npc
- trapped rooms
- boss room
 ### Items
 - Passive items
 - Usable items
   - fight
   - round
   - one time use
 ### Enemies
 - Special type
 - Random chance of spawning
 - ??
# UML - Class

```mermaid
classDiagram
direction TB
    Skeleton --|> ICreature : Implements
    Player --|> ICreature : Implements
    Game *-- BattleManager
    Game *-- BattleMap
    BattleManager <-- Player
    Game *-- Parser
    Game *-- Room
    Parser <-- Command
    Parser *-- AvailableCommands

    Main -- Game
      class ICreature{
        +BASE_DAMAGE : float
        +BASE_ARMOR : float
        <<interface>>
        +takeDamage(float damage) void
        +doDamage(ICreature creature) void
        +isDead() boolean
        +getHealth() float
      }
      class Skeleton{
        +Skeleton() 
        +getHealth() float
        +doDamage(ICreature creature) void
        +takeDamage(float damage) void
        +isDead() boolean
      }
      class Game {
        +Game()
        +play() void
        -isLastRoom(Room currentRoom) boolean
        -performCommand(Command command) boolean
        -endGame(Command command) boolean
        -moveToRoom(Command command) void
        -printRooms() void
        -printInvitation() void
        -printHelp() void
      }
      class BattleManager{
        +startFight(Player player, Room room) boolean
        -removeDeadEnemies(ArrayList~ICreature~ enemiesInRoom) ArrayList~ICreature~
        -printBattleSummaryAfterRound(ArrayList~ICreature~ enemies, int round) void
      }
      class BattleMap{
        +createMap(Game game) Room
      }
      class Room{
        +Room(String popis) 
        +putEnemiesIntoRoom() void
        +setExits(Room leftExit, Room middleExit, Room rightExit) ArrayList~ICreature~
        +get(...)
        +set(...)
      }
      class Player{
        +Player(float health, float damage, float armor)
        +getHealth() float
        +doDamage(ICreature creature) void
        +takeDamage(float damage) void
        +isDead() boolean
      }
      class AvailableCommands{
        +isCommand(String commandName) boolean
      }
      class Command{
        +Command(String commandName, String parameter)
        +isUnknown() boolean
        +hasParameter() boolean
        +get(...)
      }
      class Parser{
        +Parser()
        +getCommandFromInput() Command
      }
      class Main{
          main()
      }
```
