package com.company.WithoutThreads.View;

import com.company.WithoutThreads.Controllers.CurrentMoveController;
import com.company.WithoutThreads.Controllers.Game;
import com.company.WithoutThreads.Controllers.MoveController;
import com.company.WithoutThreads.Controllers.WinnerController;
import com.company.WithoutThreads.Exceptions.AlreadyOccupiedException;
import com.company.WithoutThreads.Exceptions.InvalidPointException;
import com.company.WithoutThreads.Model.Field;
import com.company.WithoutThreads.Model.Figure;
import com.company.WithoutThreads.Model.Player;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final WinnerController winnerController = new WinnerController();

    private final MoveController moveController = new MoveController();

    public void show(final Game<Figure> game) {

        System.out.format("Game name: %s\n", game.getName());
        final Field<Figure> field = game.getField();

        for (Player player : game.getPlayers()) {
            System.out.format("Player name: %s, figure: %s\n", player.getName(), player.getFigure());
        }

        for (int x = 0; x < field.getFieldSize(); x++) {
            if (x != 0) printSeparator();
            printLine(field, x);
        }
    }

    public boolean move(final Game<Figure> game) {
        final Field<Figure> field = game.getField();
        final Figure winner = winnerController.getWinner(field);

        if (winner != null) {
            System.out.format("Winner is %s\n", winner.name());
            return false;
        }
        final Figure currentFigure = currentMoveController.currentMove(field);

        if (currentFigure == null) {
            System.out.println("No winners in game and moves are left!");
            return false;
        }
        System.out.format("Please enter move point for: %s\n", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field, currentFigure, point);
        } catch (InvalidPointException | AlreadyOccupiedException e) {
            //e.printStackTrace();
            System.out.println("Print is invalid!");
        }
        return true;
    }

    private Point askPoint() {
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }


    private int askCoordinate(final String coordinateName) {
        System.out.format("Please, input %s: ", coordinateName);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please, enter correct input");
            return askCoordinate(coordinateName);
        }
    }

    private void printLine(final Field<Figure> field, final int x) {
        for (int y = 0; y < field.getFieldSize(); y++) {
            if (y != 0) System.out.print("|");
            System.out.print(" ");
            final Figure figure;
            try {
                figure = field.getFigure(new Point(y, x));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
        }
        System.out.println();
    }

    private void printSeparator() {
        System.out.println("~~~~~~~~~~~");
    }

}
