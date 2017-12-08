package fr.graphlabs.neo4j.repl.console.commands;

import fr.graphlabs.neo4j.repl.exercises.TraineeSession;

import java.util.Locale;
import java.util.function.BiConsumer;

public interface Command extends BiConsumer<TraineeSession, String> {

    String PREFIX = ":";

    boolean matches(String query);

    String help();

    default String normalize(String input) {
        return input.trim().toLowerCase(Locale.ENGLISH);
    }
}
