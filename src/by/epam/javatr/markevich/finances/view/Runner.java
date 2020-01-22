package by.epam.javatr.markevich.finances.view;

import by.epam.javatr.markevich.finances.controller.Controller;

public class Runner {
    public static void main(String[] args){
        Controller controller = new Controller();

        System.out.println("State:\n");
        String response = controller.executeTask("state|");
        System.out.println(response);

//        response = controller.executeTask("add|important transaction|10|TAX");
//        System.out.println(response);
//        response = controller.executeTask("add|gift|100|PAYMENT");
//        System.out.println(response);
//        response = controller.executeTask("add|buy some cookies|5|foOd");
//        System.out.println(response);
        response = controller.executeTask("update|3|buy some cookies|10|foOd");
        System.out.println(response);
        response = controller.executeTask("state|");
        System.out.println(response);
    }
}
