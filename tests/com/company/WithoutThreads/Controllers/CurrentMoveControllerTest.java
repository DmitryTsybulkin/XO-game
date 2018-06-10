package com.company.WithoutThreads.Controllers;

import com.company.WithoutThreads.Model.Field;
import com.company.WithoutThreads.Model.Figure;
import org.junit.jupiter.api.Test;

import java.awt.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CurrentMoveControllerTest {

    @Test
    void testCurrentMoveWhenNextMoveIsO() throws Exception {
        final CurrentMoveController currentMoveController = new CurrentMoveController();

        //for (int i = 0; i < 3; i++) {
            final Field<Figure> field = new Field<>(3);
            field.setFigure(new Point(0, 0), Figure.X);
            field.setFigure(new Point(0, 1), Figure.O);
            field.setFigure(new Point(0, 2), Figure.X);
            assertEquals(Figure.O, currentMoveController.currentMove(field));
        //}
    }

    @Test
    void testCurrentMoveWhenNextMoveIsX() throws Exception {
        final Field<Figure> field = new Field<>(3);
        final CurrentMoveController currentMoveController = new CurrentMoveController();

        //for (int i = 0; i < 3; i++) {
            field.setFigure(new Point(0, 1), Figure.O);
            field.setFigure(new Point(0, 2), Figure.X);
            assertEquals(Figure.X, currentMoveController.currentMove(field));
        //}
    }

    @Test
    void testCurrentMoveWhenNobodyWin() throws Exception {
        final Field<Figure> field = new Field<>(3);
        final CurrentMoveController currentMoveController = new CurrentMoveController();

        for (int i = 0; i < 3; i++) {
            for (int z = 0; z < 3; z++) {
                field.setFigure(new Point(i, z), Figure.X);
                field.setFigure(new Point(i, z), Figure.O);
            }
        }

        assertNull(currentMoveController.currentMove(field));

    }

}