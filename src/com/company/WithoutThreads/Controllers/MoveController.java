package com.company.WithoutThreads.Controllers;

import com.company.WithoutThreads.Exceptions.AlreadyOccupiedException;
import com.company.WithoutThreads.Exceptions.InvalidPointException;
import com.company.WithoutThreads.Model.Field;
import com.company.WithoutThreads.Model.Figure;

import java.awt.Point;

public class MoveController {

    public void applyFigure(final Field<Figure> field, final Figure figure, final Point point) throws
            InvalidPointException,
            AlreadyOccupiedException {
        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }

}
