package edu.kit.programming.commandsystem.ui.commands;

import edu.kit.programming.commandsystem.model.ApplicationState;

public class QuitCommand implements Command{
    private static final String REGEX = "^quit";
    @Override
    public boolean matches(String input) {
        return input.matches(REGEX);
    }

    @Override
    public String execute(ApplicationState state) {
        state.stop();
        return "";
    }
}
