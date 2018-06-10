package com.company.WithoutThreads.Model;

import com.company.WithoutThreads.Exceptions.InvalidPointException;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {
    @Test
    void setFigure() throws Exception {
        final Field<Figure> field = new Field<>(3);
        final Point point = new Point(0, 0);
        final Figure figure = Figure.X;

        field.setFigure(point, figure);

        final Figure figureActual = field.getFigure(point);

        assertEquals(figureActual, figure);
    }

    @Test
    void getFieldSize() throws Exception {
        final Field<Figure> field = new Field<>(3);
        assertEquals(3, field.getFieldSize());
    }

    @Test
    void testGetFigureWhenFigureIsNotSet() throws Exception {
        final Field<Figure> field = new Field<>(3);
        final Point point = new Point(0, 0);

        final Figure figureActual = field.getFigure(point);

        assertNull(figureActual);
    }

    @Test
    void testGetFigureWhenXIsLessThenZero() throws Exception {
        final Field<Figure> field = new Field<>(3);
        final Point inputPoint = new Point(-1,0);

        try {
            field.getFigure(inputPoint);
            fail("Not correct input point exception! X is less then 0");
        } catch (InvalidPointException e) {
            e.getMessage();
        }
    }

    @Test
    void testGetFigureWhenYIsLessThenZero() throws Exception {
        final Field<Figure> field = new Field<>(3);
        final Point inputPoint = new Point(0,-1);

        try {
            field.getFigure(inputPoint);
            fail("Not correct input point exception! Y is less then 0!");
        } catch (InvalidPointException e) {
            e.getMessage();
        }
    }

    @Test
    void testGetFigureWhenXIsMoreThenTwo() throws Exception {
        final Field<Figure> field = new Field<>(3);
        final Point inputPoint = new Point(field.getFieldSize()+1   , 0);

        try {
            field.getFigure(inputPoint);
            fail("Not correct input point exception! X is less then 0");
        } catch (InvalidPointException e) {
            e.getMessage();
        }
    }

    @Test
    void testGetFigureWhenYIsMoreThenTwo() throws Exception {
        final Field<Figure> field = new Field<>(3);
        final Point inputPoint = new Point(0,field.getFieldSize() + 1);

        try {
            field.getFigure(inputPoint);
            fail("Not correct input point exception! Y is less then 0!");
        } catch (InvalidPointException e) {}
    }

}