package com.company.WithoutThreads.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void getName() throws Exception {

        final String name = "Dima";
        final String expectedValue = name;

        final Player player = new Player(name, null);

        final String actualName = player.getName();

        assertEquals(expectedValue, actualName);



    }

    @Test
    void getFigure() throws Exception {
        final Figure figure = Figure.X;
        Figure expectedValue = figure;

        final Player player = new Player("Dima", figure);

        final Figure actualFigure = player.getFigure();

        assertEquals(expectedValue, actualFigure);
    }

}