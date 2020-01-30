package by.epam.javatr.markevich.finances.controller;

import by.epam.javatr.markevich.finances.controller.command.Command;

public class Controller {
    private static final String SEPARATOR = "|";

    private final CommandProvider provider = new CommandProvider();

    public String executeTask(String request) {
        String commandName;
        Command executionCommand;

        commandName = request.substring(0, request.indexOf(SEPARATOR));
        executionCommand = provider.getCommand(commandName);

        String response;
        response = executionCommand.execute(request.substring(request.indexOf(SEPARATOR) + 1));
        return response;
    }
}
