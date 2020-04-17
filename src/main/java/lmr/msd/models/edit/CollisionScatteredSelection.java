package lmr.msd.models.edit;

import lmr.msd.models.Collision;
import lmr.msd.tilemap.ScatteredSelection;

import java.awt.*;
import java.util.List;

public class CollisionScatteredSelection extends ScatteredSelection<
        Collision,
    CollisionRectangleSelection,
    CollisionScatteredSelection,
    Byte
> {
    public CollisionScatteredSelection(Collision collision, List<Point> points) {
        super(collision, points);
    }

    public CollisionScatteredSelection self() { return this; }
}
