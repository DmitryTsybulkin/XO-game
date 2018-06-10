package com.company.WithoutThreads.Controllers;

import com.company.WithoutThreads.Exceptions.InvalidPointException;
import com.company.WithoutThreads.Model.Field;
import com.company.WithoutThreads.Model.Figure;

import java.awt.Point;

public class CurrentMoveController {

    public Figure currentMove(final Field<Figure> field) {

        int countFigure = 0;

        for (int x = 0; x < field.getFieldSize(); x++) {
            countFigure += countFiguresInTheRow(field, x);
        }

        if (countFigure == field.getFieldSize() * field.getFieldSize()) return null;

        if (countFigure % 2 == 0) return Figure.X;

        return Figure.O;

    }

    private int countFiguresInTheRow(final Field<Figure> field, final int row) {

        int countFigure = 0;

        for (int x = 0; x < field.getFieldSize(); x++) {
            try {
                if (field.getFigure(new Point(x, row)) != null) countFigure++;
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return countFigure;
    }

}
