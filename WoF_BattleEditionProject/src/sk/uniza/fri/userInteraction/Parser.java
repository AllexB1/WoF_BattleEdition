package sk.uniza.fri.userInteraction;
import java.util.Scanner;

/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */

/**
 * Trieda MainPackage.sk.uniza.fri.Parser cita vstup zadany hracom do terminaloveho okna a pokusi sa
 * interpretovat ho ako prikaz hry. Kazda sprava dajPrikaz sposobi, ze parser
 * precita jeden riadok z terminaloveho okna a vyberie z neho prve dve slova.
 * Tie dve slova pouzije ako parametre v sprave new triede MainPackage.sk.uniza.fri.Prikaz.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */
public class Parser {
    private final AvailableCommands commands;  // odkaz na pripustne nazvy prikazov
    private final Scanner scanner;         // zdroj vstupov od hraca

    /**
     * Vytvori citac na citanie vstupov z terminaloveho okna.
     */
    public Parser() {
        this.commands = new AvailableCommands();
        this.scanner = new Scanner(System.in);
    }

    /**
     * @return prikaz zadany hracom
     */
    public Command getCommandFromInput() {
        System.out.print("> ");     // vyzva pre hraca na zadanie prikazu

        String input = this.scanner.nextLine();

        String command = null;
        String parameter = null;

        // najde prve dve slova v riadku
        Scanner tokenizer = new Scanner(input);
        if (tokenizer.hasNext()) {
            command = tokenizer.next();      // prve slovo
            if (tokenizer.hasNext()) {
                parameter = tokenizer.next();      // druhe slovo
                // vsimnite si, ze zbytok textu sa ignoruje
            }
        }

        // kontrola platnosti prikazu
        if (this.commands.isCommand(command)) {
            // vytvori platny prikaz
            return new Command(command, parameter);
        } else {
            // vytvori neplatny - "neznamy" prikaz
            return new Command(null, parameter);
        }
    }
}

