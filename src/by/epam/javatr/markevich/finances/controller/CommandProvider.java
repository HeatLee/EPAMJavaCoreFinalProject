package by.epam.javatr.markevich.finances.controller;

import by.epam.javatr.markevich.finances.controller.command.Command;
import by.epam.javatr.markevich.finances.controller.command.CommandName;
import by.epam.javatr.markevich.finances.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.ADD, new AddTransaction());
        repository.put(CommandName.BALANCE, new CalculateBalance());
        repository.put(CommandName.DELETE, new DeleteTransaction());
        repository.put(CommandName.GET, new GetTransaction());
        repository.put(CommandName.STATE, new ViewTransactionLog());
        repository.put(CommandName.UPDATE, new UpdateTransaction());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    public Command getCommand(String name) {
        Command command;
        CommandName commandName;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
