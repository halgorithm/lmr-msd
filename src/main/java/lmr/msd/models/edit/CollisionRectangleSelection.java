package lmr.msd.models.edit;

import lmr.msd.models.Collision;
import lmr.msd.models.CollisionType;
import lmr.msd.tilemap.RectangleSelection;

import java.awt.*;

public class CollisionRectangleSelection extends RectangleSelection<
        Collision, CollisionRectangleSelection, CollisionScatteredSelection, Byte
> {
    public CollisionRectangleSelection(Collision collision, Rectangle rect) {
        super(collision, rect);
    }

    public CollisionRectangleSelection ladderFill() {
        setEach((x, y) -> {
            switch (x % 4) {
                case 0: return CollisionType.LADDER_LEFT;
                case 1: return CollisionType.LADDER_LEFT_CENTER;
                case 2: return CollisionType.LADDER_RIGHT_CENTER;
                default: return CollisionType.LADDER_RIGHT;
            }
        });

        return this;
    }

    public CollisionRectangleSelection waterLadderFill() {
        setEach((x, y) -> {
            switch (x % 4) {
                case 0: return CollisionType.WATER_LADDER_LEFT;
                case 1: return CollisionType.WATER_LADDER_LEFT_CENTER;
                case 2: return CollisionType.WATER_LADDER_RIGHT_CENTER;
                default: return CollisionType.WATER_LADDER_RIGHT;
            }
        });

        return this;
    }

    public CollisionRectangleSelection lavaLadderFill() {
        setEach((x, y) -> {
            switch (x % 4) {
                case 0: return CollisionType.LAVA_LADDER_LEFT;
                case 1: return CollisionType.LAVA_LADDER_LEFT_CENTER;
                case 2:return CollisionType.LAVA_LADDER_RIGHT_CENTER;
                default: return CollisionType.LAVA_LADDER_RIGHT;
            }
        });

        return this;
    }

    public CollisionRectangleSelection erase() {
        return fill(CollisionType.EMPTY);
    }

    public CollisionRectangleSelection moveTiles(int dx, int dy) {
        return moveTiles(dx, dy, CollisionType.EMPTY);
    }

    public CollisionRectangleSelection self() {
        return this;
    }
}
