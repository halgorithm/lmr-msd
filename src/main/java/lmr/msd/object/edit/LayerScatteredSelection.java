package lmr.msd.object.edit;

import lmr.msd.object.GfxTile;
import lmr.msd.object.Layer;
import lmr.msd.tilemap.ScatteredSelection;

import java.awt.*;
import java.util.List;

public class LayerScatteredSelection extends ScatteredSelection<
    Layer, LayerRectangleSelection, LayerScatteredSelection, GfxTile
> {
    public LayerScatteredSelection(Layer layer, List<Point> points) {
        super(layer, points);
    }

    public LayerScatteredSelection self() { return this; }
}
