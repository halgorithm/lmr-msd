package lmr.msd.validate;

import lmr.msd.models.LayerGroup;
import lmr.msd.models.Scene;
import lmr.msd.models.Stage;

public class LayerDimensionsMismatchException extends LayerGroupException {
    public LayerDimensionsMismatchException(Stage stage, Scene scene, LayerGroup layerGroup) {
        super("Layers in LayerGroup have inconsistent dimensions.", stage, scene, layerGroup);
    }
}
