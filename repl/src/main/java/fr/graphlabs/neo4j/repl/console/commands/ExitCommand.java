package fr.graphlabs.neo4j.repl.console.commands;

import fr.graphlabs.neo4j.repl.exercises.TraineeSession;
import fr.graphlabs.neo4j.repl.logging.ConsoleLogger;
import org.jline.utils.AttributedStyle;

import static org.jline.utils.AttributedStyle.MAGENTA;

public class ExitCommand implements Command {

    private final ConsoleLogger logger;

    public ExitCommand(ConsoleLogger logger) {
        this.logger = logger;
    }

    @Override
    public boolean matches(String query) {
        return normalize(query).equals(":exit");
    }

    @Override
    public String help() {
        return String.format("%s%s - exits REPL", PREFIX, "exit");
    }

    @Override
    public void accept(TraineeSession session, String s) {
        logger.log(
                "     .-\"\"\"\"\"\"-.\n" +
                        "   .'          '.\n" +
                        "  /   O      O   \\\n" +
                        " :           `    :\n" +
                        " |                |\n" +
                        " :    .------.    :\n" +
                        "  \\  '        '  /\n" +
                        "   '.          .'\n" +
                        "     '-......-'\n"
                        + "Sad to see you go", AttributedStyle.DEFAULT.blink().italic().foreground(MAGENTA));
        System.exit(0);
    }
}
