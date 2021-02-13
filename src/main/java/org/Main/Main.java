package org.Main;

import org.Entity.Book;
import org.Logic.Service;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.doCommand();
    }
}
