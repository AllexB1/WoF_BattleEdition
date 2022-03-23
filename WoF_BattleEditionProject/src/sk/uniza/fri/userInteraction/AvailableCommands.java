package sk.uniza.fri.userInteraction;

/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */
public class AvailableCommands {
    // konstantne pole nazvov prikazov
    private static final String[] VALID_COMMANDS = {
            "go", "end", "help", "show", "consume"
    };

    /**
     * Kontroluje, ci nazov v parametri je platny prikaz.
     *
     * @return true ak je parameter platny prikaz,
     * false inak.
     */
    public boolean isCommand(String commandName) {
        for (int i = 0; i < AvailableCommands.VALID_COMMANDS.length; i++) {
            if (AvailableCommands.VALID_COMMANDS[i].equals(commandName)) {
                return true;
            }
        }
        // ak algoritmus dosiahne tento bod, parameter nie je platny prikaz
        return false;
    }
}
