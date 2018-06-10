package com.company.WithThreads;

import com.company.WithoutThreads.Exceptions.InvalidPointException;
import com.company.WithoutThreads.Model.Field;
import com.company.WithoutThreads.Model.Figure;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class GraphBuilder {

    public GraphNode build(final Figure currentFigure, final Field currentField) throws InvalidPointException {
        final Figure nextFigure = currentFigure == Figure.O ? Figure.X : Figure.O;
        final Set<GraphNode> children = new HashSet<>();
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (currentField.getFigure(new Point(x, y)) != null) {
                    continue;
                }
                final Field newField = new Field(currentField);
                newField.setFigure(new Point(x, y), nextFigure);
                children.add(build(nextFigure, newField));
            }
        }
        return new GraphNode(currentField, children);
    }
}
