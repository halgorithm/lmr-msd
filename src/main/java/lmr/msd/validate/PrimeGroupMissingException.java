package lmr.msd.validate;

import lmr.msd.models.Scene;
import lmr.msd.models.Stage;

public class PrimeGroupMissingException extends SceneValidationException {
    public PrimeGroupMissingException(Stage stage, Scene scene) {
        super("Scene has no prime LayerGroup.", stage, scene);
    }
}
