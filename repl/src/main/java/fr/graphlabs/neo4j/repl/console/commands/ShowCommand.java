package fr.graphlabs.neo4j.repl.console.commands;

import fr.graphlabs.neo4j.repl.exercises.Exercise;
import fr.graphlabs.neo4j.repl.exercises.TraineeSession;
import fr.graphlabs.neo4j.repl.logging.ConsoleLogger;
import org.jline.utils.AttributedStyle;

import static org.jline.utils.AttributedStyle.BLUE;

public class ShowCommand implements Command {

    private final ConsoleLogger logger;

    public ShowCommand(ConsoleLogger logger) {
        this.logger = logger;
    }

    @Override
    public boolean matches(String query) {
        return normalize(query).equals(PREFIX + "show");
    }

    @Override
    public String help() {
        return String.format("%s%s - shows current exercise instructions", PREFIX, "show");
    }

    @Override
    public void accept(TraineeSession session, String ignored) {
        session.getCurrentExercise().accept(logger);
    }

    @Override
    public String toString() {
        return ":show";
    }
}
