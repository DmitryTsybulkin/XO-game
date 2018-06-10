package com.company.WithoutThreads.Controllers;

import com.company.WithoutThreads.Exceptions.InvalidPointException;
import com.company.WithoutThreads.Model.Field;
import com.company.WithoutThreads.Model.Figure;

import java.awt.Point;

public class WinnerController {

    public Figure getWinner(final Field<Figure> field) {
        try {

            for (int i = 0; i < 3; i++) {
                if (check(field, new Point(i, 0), point -> new Point(point.x, point.y + 1)))
                    return field.getFigure(new Point(i, 0));
            }

            for (int i = 0; i < 3; i++) {
                if (check(field, new Point(0, i), point -> new Point(point.x + 1, point.y)))
                    return field.getFigure(new Point(0, i));
            }

            if (check(field, new Point(0, 0), point -> new Point(point.x + 1, point.y + 1)))
                return field.getFigure(new Point(1, 1));

            if (check(field, new Point(0, 2), point -> new Point(point.x + 1, point.y - 1)))
                return field.getFigure(new Point(1, 1));

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * TODO: разобратсья в методе и прочитать про вложенные интерфейсы, классы и абстрактные классы
     * http://pr0java.blogspot.ru/2015/07/2.html
     * @param field - поле
     * @param currentPoint - поинт в который ходит фигура в этом ходе
     * @param rule - правило по которому ходит(?)
     * @return true если всё хорошо
     */
    private boolean check(final Field<Figure> field, final Point currentPoint, final IPointGenerator rule) {

        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = rule.next(currentPoint);

        try {
            currentFigure = field.getFigure(currentPoint);

            if (currentFigure == null) return false;

            nextFigure = field.getFigure(nextPoint);
        } catch (InvalidPointException e) {
            return true;
        }

        if (currentFigure != nextFigure) return false;

        return check(field, nextPoint, rule);
    }

    private interface IPointGenerator {
        Point next(final Point point);
    }

}
