package com.company;

import com.company.WithoutThreads.Controllers.Game;
import com.company.WithoutThreads.Model.Field;
import com.company.WithoutThreads.Model.Figure;
import com.company.WithoutThreads.Model.Player;
import com.company.WithoutThreads.View.ConsoleView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String name1 = playerNameInput(1);
        final String name2 = playerNameInput(2);

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game<Figure> game = new Game<>(players, new Field<>(3), "XO");
        final ConsoleView consoleView = new ConsoleView();

        consoleView.show(game);
        while (consoleView.move(game)) {
            consoleView.show(game);
        }
    }

    static String playerNameInput(final int count) {
        Scanner scanner = new Scanner(System.in);
        System.out.format("Enter player %s name: ", count);
        return scanner.nextLine();
    }
}



