package lmr.msd.validate;

import lmr.msd.object.Scene;
import lmr.msd.object.Stage;

public abstract class SceneValidationException extends MsdValidationException {
    public final Scene scene;

    public SceneValidationException(String s, Stage stage, Scene scene) {
        super(s, stage);
        this.scene = scene;
    }
}
