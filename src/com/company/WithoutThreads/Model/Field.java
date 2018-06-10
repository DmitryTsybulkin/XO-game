package com.company.WithoutThreads.Model;

import com.company.WithoutThreads.Exceptions.InvalidPointException;

import java.awt.Point;

public class Field<T> {

    private static final int MIN_COORDINATE = 0;

    private final T[][] field;

    private final int FIELD_SIZE;

    public Field(final int field_size) {
        this.FIELD_SIZE = field_size;
        field = (T[][]) new Object[field_size][field_size];
    }

    public Field(Field currentField) {
        this.FIELD_SIZE = currentField.FIELD_SIZE;
        this.field = (T[][]) currentField.field;
    }

    public T getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final T figure) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        this.field[point.x][point.y] = figure;
    }

    public int getFieldSize() {
        return FIELD_SIZE;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.x, field.length) && checkCoordinate(point.y, field[point.x].length);
    }

    private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
    }

}
