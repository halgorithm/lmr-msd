package lmr.msd.models.edit;

import lmr.msd.models.GfxTile;
import lmr.msd.models.Layer;
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
