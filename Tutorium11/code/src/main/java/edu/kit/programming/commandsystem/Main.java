package edu.kit.programming.commandsystem;

import edu.kit.programming.commandsystem.model.ApplicationState;
import edu.kit.programming.commandsystem.ui.UserInterface;

public class Main {
    public static void main(String[] args) {
        ApplicationState state = new ApplicationState();
        UserInterface userInterface = new UserInterface(state);
        userInterface.run();
    }
}