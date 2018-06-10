package com.company.WithoutThreads.Controllers;

import com.company.WithoutThreads.Model.Field;
import com.company.WithoutThreads.Model.Figure;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class WinnerControllerTest {
    @Test
    void getWinnerWhenWinnerRow() throws Exception {
        final Field<Figure> field = new Field<>(3);
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(field));
        }

    }

    @Test
    public void testGetWinnerWhenNoWinnerRow() throws Exception {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field<Figure> field = new Field<>(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.O);
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerRow2() throws Exception {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field<Figure> field = new Field<>(3);
            field.setFigure(new Point(i, 0), Figure.O);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.X);
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenWinnerColumn() throws Exception {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field<Figure> field = new Field<>(3);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerColumn() throws Exception {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field<Figure> field = new Field<>(3);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.O);
            field.setFigure(new Point(2, i), Figure.X);
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerWhenWinnerDiagonal_1() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field<Figure> field = new Field<>(3);
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.X);
        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerWhenNoWinnerDiagonal_1() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field<Figure> field = new Field<>(3);
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.O);
        assertNull(winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerWhenWinnerDiagonal_2() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field<Figure> field = new Field<>(3);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 0), Figure.X);
        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerWhenNoWinnerDiagonal_2() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field<Figure> field = new Field<>(3);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 0), Figure.O);
        assertNull(winnerController.getWinner(field));
    }



}