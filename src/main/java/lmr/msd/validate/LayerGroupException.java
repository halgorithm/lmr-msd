package lmr.msd.validate;

import lmr.msd.object.LayerGroup;
import lmr.msd.object.Scene;
import lmr.msd.object.Stage;

public abstract class LayerGroupException extends SceneValidationException {
    public final LayerGroup layerGroup;

    public LayerGroupException(String s, Stage stage, Scene scene, LayerGroup layerGroup) {
        super(s, stage, scene);
        this.layerGroup = layerGroup;
    }
}
