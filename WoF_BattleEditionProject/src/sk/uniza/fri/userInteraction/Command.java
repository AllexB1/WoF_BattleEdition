package sk.uniza.fri.userInteraction;

/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */
public class Command {
    private final String commandName;
    private final String parameter;

    /**
     * Inicializuje slova prikazu dvomi zadanymi parametrami. Jeden alebo oba
     * parametre mozu mat hodnotu <null>.

     * @param commandName prve slovo - nazov prikazu,
     *                       null, ak je prikaz neznamy.
     * @param parameter druhe slovo prikazu.
     */
    public Command(String commandName, String parameter) {
        this.commandName = commandName;
        this.parameter = parameter;
    }

    /**
     * @return prve slovo - nazov prikazu.
     */
    public String getName() {
        return this.commandName;
    }

    /**
     * @return druhe slovo - parameter prikazu.
     */
    public String getParameter() {
        return this.parameter;
    }

    /**
     * @return true, ak je prikaz neznamy.
     */
    public boolean isUnknown() {
        return this.commandName == null;
    }

    /**
     * @return true, ak prikaz ma parameter.
     */
    public boolean hasParameter() {
        return this.parameter != null;
    }
}
