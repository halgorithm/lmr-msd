package lmr.msd.models;

import lmr.msd.models.edit.CollisionRectangleSelection;
import lmr.msd.models.edit.CollisionScatteredSelection;
import lmr.msd.tilemap.TileMap;

import java.awt.*;
import java.util.List;

public class Collision extends TileMap<
    Collision,
        CollisionRectangleSelection,
        CollisionScatteredSelection,
    Byte
> {
    public Collision(List<List<Byte>> data) {
        super(data);
    }

    public Collision self() {
        return this;
    }

    public CollisionRectangleSelection select(Rectangle rect) {
        return new CollisionRectangleSelection(this, rect);
    }

    public CollisionScatteredSelection select(List<Point> points) {
        return new CollisionScatteredSelection(this, points);
    }

    public Collision make(List<List<Byte>> data) {
        return new Collision(data);
    }
}
