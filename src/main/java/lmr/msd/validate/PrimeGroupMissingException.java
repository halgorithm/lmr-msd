package lmr.msd.validate;

import lmr.msd.object.Scene;
import lmr.msd.object.Stage;

public class PrimeGroupMissingException extends SceneValidationException {
    public PrimeGroupMissingException(Stage stage, Scene scene) {
        super("Scene has no prime LayerGroup.", stage, scene);
    }
}
