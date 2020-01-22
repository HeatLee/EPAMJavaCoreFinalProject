package by.epam.javatr.markevich.finances.controller.command;

public interface Command {
    String REGEX = "\\|";
    String INVALID_PARAMETERS_AMOUNT_RESPONSE = "Invalid amount of parameters";
    String INVALID_PARAMETER_VALUE_RESPONSE = "Invalid transmitted parameter value";
    String execute(String request);
}
