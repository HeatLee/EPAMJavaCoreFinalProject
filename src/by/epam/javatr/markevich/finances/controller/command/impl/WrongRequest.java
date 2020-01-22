package by.epam.javatr.markevich.finances.controller.command.impl;

import by.epam.javatr.markevich.finances.controller.command.Command;

public class WrongRequest implements Command {
    private static final String WRONG_REQUEST_RESPONSE = "Cannot execute such request";
    @Override
    public String execute(String request) {
        return WRONG_REQUEST_RESPONSE;
    }
}
