package lmr.msd.validate;

import lmr.msd.models.LayerGroup;
import lmr.msd.models.Scene;
import lmr.msd.models.Stage;

public abstract class LayerGroupException extends SceneValidationException {
    public final LayerGroup layerGroup;

    public LayerGroupException(String s, Stage stage, Scene scene, LayerGroup layerGroup) {
        super(s, stage, scene);
        this.layerGroup = layerGroup;
    }
}
