package lmr.msd.validate;

import lmr.msd.models.Scene;
import lmr.msd.models.Stage;

public abstract class SceneValidationException extends MsdValidationException {
    public final Scene scene;

    public SceneValidationException(String s, Stage stage, Scene scene) {
        super(s, stage);
        this.scene = scene;
    }
}
