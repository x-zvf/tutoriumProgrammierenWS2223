package edu.kit.programming.commandsystem.ui.commands;

import edu.kit.programming.commandsystem.ApplicationException;
import edu.kit.programming.commandsystem.model.ApplicationState;

import java.util.regex.Pattern;

public interface Command {

    boolean matches(String input);
    String execute(ApplicationState state) throws ApplicationException;
}
