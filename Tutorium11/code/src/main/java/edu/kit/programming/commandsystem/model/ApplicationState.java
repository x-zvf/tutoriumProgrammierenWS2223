package edu.kit.programming.commandsystem.model;

public class ApplicationState {
    private boolean running = true;

    public void stop() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }
}
