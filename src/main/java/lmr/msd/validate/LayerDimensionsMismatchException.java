package lmr.msd.validate;

import lmr.msd.object.LayerGroup;
import lmr.msd.object.Scene;
import lmr.msd.object.Stage;

public class LayerDimensionsMismatchException extends LayerGroupException {
    public LayerDimensionsMismatchException(Stage stage, Scene scene, LayerGroup layerGroup) {
        super("Layers in LayerGroup have inconsistent dimensions.", stage, scene, layerGroup);
    }
}
