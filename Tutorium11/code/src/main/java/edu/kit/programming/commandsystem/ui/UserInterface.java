package edu.kit.programming.commandsystem.ui;

import edu.kit.programming.commandsystem.ApplicationException;
import edu.kit.programming.commandsystem.model.ApplicationState;
import edu.kit.programming.commandsystem.ui.commands.Command;
import edu.kit.programming.commandsystem.ui.commands.QuitCommand;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private ApplicationState state;
    List<Command> commands = List.of(new QuitCommand());
    public UserInterface(ApplicationState state) {
        this.state = state;
    }

    public void run() {
        try(Scanner scanner = new Scanner(System.in)) {
            while(state.isRunning()) {
                String input = scanner.nextLine();
                parseAndRun(input);
            }
        }
    }

    private void parseAndRun(String input) {
        for(Command command : commands) {
            if(command.matches(input)) {
                try {
                    System.out.println(command.execute(state));
                } catch(ApplicationException e) {
                    System.out.println(e.getMessage());
                    state.stop();
                }
            }
        }
    }
}
